package cool.tdl.seckill.service.Impl;

import cool.tdl.seckill.entity.Goods;
import cool.tdl.seckill.mapper.GoodsMapper;
import cool.tdl.seckill.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.tdl.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}
