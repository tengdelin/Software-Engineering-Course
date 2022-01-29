package cool.tdl.seckill.vo;

import cool.tdl.seckill.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author tdl
 * @Date 2022/1/8 17:37
 * @description 商品返回实体
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    private BigDecimal seckillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}