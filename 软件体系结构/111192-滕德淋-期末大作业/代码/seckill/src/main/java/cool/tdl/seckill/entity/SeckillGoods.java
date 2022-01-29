package cool.tdl.seckill.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_seckill_goods")
@ApiModel(value="SeckillGoods对象", description="秒杀商品表")
public class SeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "秒杀商品ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "秒杀价")
    private BigDecimal seckillPrice;

    @ApiModelProperty(value = "库存数量")
    private Integer stockCount;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date startDate;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date endDate;

}
