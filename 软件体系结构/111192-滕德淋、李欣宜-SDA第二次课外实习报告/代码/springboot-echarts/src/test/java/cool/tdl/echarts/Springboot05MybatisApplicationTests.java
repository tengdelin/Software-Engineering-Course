package cool.tdl.echarts;

import cool.tdl.echarts.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {
    @Autowired
    private StockService stockService;

    @Test
    void contextLoads() {
        System.out.println(stockService.selectAllshiyinlv(0,10));
        System.out.println(stockService.selectAllshiyinlv(10,20));
        System.out.println(stockService.selectAllshiyinlv(20,30));
        System.out.println(stockService.selectAllshiyinlv(30,40));
        System.out.println(stockService.selectAllshiyinlv(40,50));
        System.out.println(stockService.selectAllshiyinlv(50,60));
        System.out.println(stockService.selectAllshiyinlv(60,70));
        System.out.println(stockService.selectAllshiyinlv(70,80));
        System.out.println(stockService.selectAllshiyinlv(80,90));
        System.out.println(stockService.selectAllshiyinlv(90,100));

    }

    @Test
    public void test(){
        System.out.println(stockService.selectAlljunjia());
    }
    @Test
    public void test1(){
        System.out.println(stockService.selectAllshoupanjia());
    }

}
