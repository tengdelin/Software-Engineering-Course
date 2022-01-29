package cool.tdl.seckill.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_goods")
@ApiModel(value="Goods对象", description="商品表")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品标题")
    private String goodsTitle;

    @ApiModelProperty(value = "商品图片")
    private String goodsImg;

    @ApiModelProperty(value = "商品描述")
    private String goodsDetail;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品库存,-1表示没有限制")
    private Integer goodsStock;


}
