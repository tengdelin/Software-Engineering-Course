package cool.tdl.echarts.service;

import cool.tdl.echarts.mapper.StockMapper;
import cool.tdl.echarts.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockMapper stockMapper;

    public List<Stock> selectAllStock() {
        return stockMapper.selectAllStock();
    }

    public List<Stock> selectAllshiyinlv(float minnum, float maxnum) {
        return stockMapper.selectAllshiyinlv(minnum, maxnum);
    }

    public List<Stock> selectAlljunjia() {
        return stockMapper.selectAlljunjia();
    }


    public List<Stock> selectAllshoupanjia() {
        return stockMapper.selectAllshoupanjia();
    }


}
