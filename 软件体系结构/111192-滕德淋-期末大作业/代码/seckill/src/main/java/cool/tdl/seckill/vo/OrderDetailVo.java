package cool.tdl.seckill.vo;

import cool.tdl.seckill.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tdl
 * @Date 2022/1/9 17:25
 * @description 订单详情页数据对象
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailVo {
    private Order order;

    private GoodsVo goodsVo;
}