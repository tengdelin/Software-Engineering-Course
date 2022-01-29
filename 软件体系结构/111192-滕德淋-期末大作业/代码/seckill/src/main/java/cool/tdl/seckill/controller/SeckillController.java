package cool.tdl.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.captcha.ArithmeticCaptcha;
import cool.tdl.seckill.config.AccessLimit;
import cool.tdl.seckill.entity.Order;
import cool.tdl.seckill.entity.SeckillMessage;
import cool.tdl.seckill.entity.SeckillOrder;
import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.exception.GlobalException;
import cool.tdl.seckill.rabbitmq.MQSender;
import cool.tdl.seckill.service.GoodsService;
import cool.tdl.seckill.service.OrderService;
import cool.tdl.seckill.service.SeckillOrderService;
import cool.tdl.seckill.utils.JsonUtil;
import cool.tdl.seckill.vo.GoodsVo;
import cool.tdl.seckill.vo.RespBean;
import cool.tdl.seckill.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @Author tdl
 * @Date 2022/1/8 21:39
 * @description 秒杀功能
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeckillOrderService seckillOrderService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MQSender mqSender;

    private Map<Long, Boolean> EmptyStockMap = new HashMap<>();

    @Autowired
    private RedisScript<Long> script;


    /**
     * 秒杀接口
     * Windows QPS= 110.4
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user, Long goodsId) {
        //判断是否登录
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if (goods.getStockCount() < 1) {
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if (seckillOrder != null) {
            model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
            return "secKillFail";
        }
        Order order = orderService.seckill(user, goods);
        model.addAttribute("order", order);
        model.addAttribute("goods", goods);
        return "orderDetail";
    }


    /**
     * 订单详情静态化接口
     * windows QPS = 47.935
     *
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/doSeckill2", method = RequestMethod.POST)
    @ResponseBody
    public RespBean doSeckill2(User user, Long goodsId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if (goods.getStockCount() < 1) {
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }
//        //判断是否重复抢购
//        SeckillOrder seckillOrder = seckillOrderService.getOne(new
//                QueryWrapper<SeckillOrder>().eq("user_id",
//                user.getId()).eq(
//                "goods_id",
//                goodsId));
        //从redis中获取秒杀订单信息，减少访问数据库
        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if (seckillOrder != null) {
            return RespBean.error(RespBeanEnum.REPEATE_ERROR);
        }
        Order order = orderService.seckill(user, goods);
        return RespBean.success(order);
    }


    /**
     * 优化秒杀，使用redis获取商品库存
     * windows QPS = 1820.6
     *
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/{path}/doSeckill3", method = RequestMethod.POST)
    @ResponseBody
    public RespBean doSeckill3(@PathVariable String path, User user, Long goodsId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();

        boolean check = orderService.checkPath(user, goodsId, path);
        if (!check) {
            return RespBean.error(RespBeanEnum.REQUEST_ILLEGAL);
        }

        //判断是否重复抢购
        //从redis中获取秒杀订单信息，减少访问数据库
        String seckillOrder = (String) valueOperations.get("order:" + user.getId() + ":" + goodsId);
        if (seckillOrder != null) {
            return RespBean.error(RespBeanEnum.REPEATE_ERROR);
        }

        //内存标记,减少Redis访问
        if (EmptyStockMap.get(goodsId)) {
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }
        //预减库存
        Long stock = valueOperations.decrement("seckillGoods:" + goodsId);
        //预减库存,使用redis分布式锁
//        Long stock = (Long) redisTemplate.execute(script, Collections.singletonList("seckillGoods:" + goodsId), Collections.EMPTY_LIST);
        if (stock < 0) {
            EmptyStockMap.put(goodsId, true);
            valueOperations.increment("seckillGoods:" + goodsId);
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }

        SeckillMessage seckillMessage = new SeckillMessage(user, goodsId);
        mqSender.sendSeckillMessage(JsonUtil.object2JsonStr(seckillMessage));
        return RespBean.success(0);
    }


    /**
     * 获取秒杀结果
     * -1秒杀失败，0排队中
     *
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public RespBean getResult(User user, Long goodsId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        Long orderId = seckillOrderService.getResult(user, goodsId);
        return RespBean.success(orderId);
    }


    /**
     * 获得秒杀用户唯一url
     * @param user
     * @param goodsId
     * @return
     */
    @AccessLimit(second = 5, maxCount = 5, needLogin = true)
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    @ResponseBody
    public RespBean getPath(User user, Long goodsId,String captcha) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }

        //验证验证码
        boolean check = orderService.checkCaptcha(user, goodsId, captcha);
        if (!check){
            return RespBean.error(RespBeanEnum.ERROR_CAPTCHA);
        }

        String str = orderService.createPath(user, goodsId);
        return RespBean.success(str);
    }


    /**
     * 生成验证码
     * @param user
     * @param goodsId
     * @param response
     */
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void verifyCode(User user, Long goodsId, HttpServletResponse response) {
        if (null==user||goodsId<0){
            throw new GlobalException(RespBeanEnum.REQUEST_ILLEGAL);
        }
        // 设置请求头为输出图片类型
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //生成验证码，将结果放入redis
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 32, 3);

        redisTemplate.opsForValue().set("captcha:"+user.getId()+":"+goodsId,captcha.text(),300, TimeUnit.SECONDS);
        try {
            captcha.out(response.getOutputStream());
        } catch (IOException e) {
            log.error("验证码生成失败",e.getMessage());
        }
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsVo> list = goodsService.findGoodsVo();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        list.forEach(goodsVo -> {
            redisTemplate.opsForValue().set("seckillGoods:" + goodsVo.getId(),
                    goodsVo.getStockCount());
            EmptyStockMap.put(goodsVo.getId(), false);
        });
    }
}
