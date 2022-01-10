package cool.tdl.echarts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockController {

    @RequestMapping("/demoV1")
    public String demoV1(){
        return "demoV1";
    }
    @RequestMapping("/demoV2")
    public String demoV2(){
        return "demoV2";
    }


    @RequestMapping("/shiyinlv")
    public String selectAllStock1() {
        return "shiyinlv";
    }

    @RequestMapping("/junjia")
    public String selectAllStock2() {
        return "junjia";
    }

    @RequestMapping("/shoupanjia")
    public String selectAllStock3() {
        return "shoupanjia";
    }

    @RequestMapping("/stocklist")
    public String selectAllStock4() {
        return "stocklist";
    }


}
