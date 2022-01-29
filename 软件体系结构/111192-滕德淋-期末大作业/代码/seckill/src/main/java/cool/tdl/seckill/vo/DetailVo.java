package cool.tdl.seckill.vo;

import cool.tdl.seckill.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tdl
 * @Date 2022/1/9 16:19
 * @description 商品详情静态化，返回数据对象
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVo {

    private User user;

    private GoodsVo goodsVo;

    private int secKillStatus;

    private int remainSeconds;
}

