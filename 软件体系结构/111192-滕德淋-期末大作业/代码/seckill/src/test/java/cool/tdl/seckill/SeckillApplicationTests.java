package cool.tdl.seckill;

import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.mapper.GoodsMapper;
import cool.tdl.seckill.mapper.UserMapper;
import cool.tdl.seckill.service.GoodsService;
import cool.tdl.seckill.vo.GoodsVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class SeckillApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
//        List<User> users = userMapper.selectList(null);
//        for (User user:users){
//            System.out.println(user);
//        }

//        List<GoodsVo> goodsVo = goodsMapper.findGoodsVo();
//        for (GoodsVo gv:goodsVo){
//            System.out.println(gv);
//        }
    }

}
