package cool.tdl.echarts.mapper;


import cool.tdl.echarts.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StockMapper {
    List<Stock> selectAllStock();
    List<Stock> selectAllshiyinlv(float minnum,float maxnum);
    List<Stock> selectAlljunjia();
    List<Stock> selectAllshoupanjia();
}
