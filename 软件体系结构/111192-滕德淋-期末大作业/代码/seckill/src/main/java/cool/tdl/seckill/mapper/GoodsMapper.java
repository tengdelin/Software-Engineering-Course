package cool.tdl.seckill.mapper;

import cool.tdl.seckill.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.tdl.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */

@Repository
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
