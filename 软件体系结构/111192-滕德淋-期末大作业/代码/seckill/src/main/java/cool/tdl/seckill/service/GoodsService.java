package cool.tdl.seckill.service;

import cool.tdl.seckill.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.tdl.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
public interface GoodsService extends IService<Goods> {
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
