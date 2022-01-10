package cool.tdl.echarts.controller;

import com.alibaba.fastjson.JSON;
import cool.tdl.echarts.pojo.ShiyinlvData;
import cool.tdl.echarts.pojo.Stock;
import cool.tdl.echarts.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {
    @Autowired
    private StockService stockService;

    @RequestMapping("/shiyinlvdata")
    public String selectdata1() {
        List<Stock> shiyinlvDataList1 = stockService.selectAllshiyinlv(0, 10);
        ShiyinlvData item1 = new ShiyinlvData("0%-10%", shiyinlvDataList1.size());

        List<Stock> shiyinlvDataList2 = stockService.selectAllshiyinlv(10, 20);
        ShiyinlvData item2 = new ShiyinlvData("10%-20%", shiyinlvDataList2.size());

        List<Stock> shiyinlvDataList3 = stockService.selectAllshiyinlv(20, 30);
        ShiyinlvData item3 = new ShiyinlvData("20%-30%", shiyinlvDataList3.size());

        List<Stock> shiyinlvDataList4 = stockService.selectAllshiyinlv(30, 40);
        ShiyinlvData item4 = new ShiyinlvData("30%-40%", shiyinlvDataList4.size());

        List<Stock> shiyinlvDataList5 = stockService.selectAllshiyinlv(40, 50);
        ShiyinlvData item5 = new ShiyinlvData("40%-50%", shiyinlvDataList5.size());

        List<Stock> shiyinlvDataList6 = stockService.selectAllshiyinlv(50, 60);
        ShiyinlvData item6 = new ShiyinlvData("50%-60%", shiyinlvDataList6.size());

        List<Stock> shiyinlvDataList7 = stockService.selectAllshiyinlv(60, 70);
        ShiyinlvData item7 = new ShiyinlvData("60%-70%", shiyinlvDataList7.size());

        List<Stock> shiyinlvDataList8 = stockService.selectAllshiyinlv(70, 80);
        ShiyinlvData item8 = new ShiyinlvData("70%-80%", shiyinlvDataList8.size());

        List<Stock> shiyinlvDataList9 = stockService.selectAllshiyinlv(80, 90);
        ShiyinlvData item9 = new ShiyinlvData("80%-90%", shiyinlvDataList9.size());

        List<Stock> shiyinlvDataList10 = stockService.selectAllshiyinlv(90, 100);
        ShiyinlvData item10 = new ShiyinlvData("90%-100%", shiyinlvDataList10.size());


        ArrayList<ShiyinlvData> arrayList = new ArrayList<>();
        arrayList.add(item1);
        arrayList.add(item2);
        arrayList.add(item3);
        arrayList.add(item4);
        arrayList.add(item5);
        arrayList.add(item6);
        arrayList.add(item7);
        arrayList.add(item8);
        arrayList.add(item9);
        arrayList.add(item10);


        String jsonString = JSON.toJSONString(arrayList);
        return jsonString;
    }


    @RequestMapping("/junjiadata")
    public ArrayList<ArrayList<String>> selectdata2() {

        ArrayList<String> listtime = new ArrayList<>();
        ArrayList<String> listjunjia = new ArrayList<>();
        List<Stock> stocks = stockService.selectAlljunjia();

        for (Stock s : stocks) {
            listtime.add(s.getTime());
            listjunjia.add(s.getJunjia());
        }

        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        arrayLists.add(listtime);
        arrayLists.add(listjunjia);

        return arrayLists;
    }


    @RequestMapping("/shoupanjiadata")
    public ArrayList<ArrayList<String>> selectdata3() {

        ArrayList<String> listtime = new ArrayList<>();
        ArrayList<String> listshoupanjia = new ArrayList<>();
        List<Stock> stocks = stockService.selectAllshoupanjia();

        for (Stock s : stocks) {
            listtime.add(s.getTime());
            listshoupanjia.add(s.getShoupanjia());
        }

        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        arrayLists.add(listtime);
        arrayLists.add(listshoupanjia);

        return arrayLists;
    }

    @RequestMapping("/stocklistdata")
    public List<Stock> seletcdata4() {
        return stockService.selectAllStock();
    }

}
