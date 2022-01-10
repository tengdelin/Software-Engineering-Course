package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Calc;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;


public class CalcTest {
    public static String FileUtil(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    @Test
    public void UnitTest(List<Calc> list) {
        CalcController calcController = new CalcController();
        int res = 0;
        for (int i=0;i<list.size();i++) {
            res = calcController.calcRes(list.get(i));
            assertEquals("测试成功", res,list.get(i).getRes());
            System.out.println("测试通过"+(i+1));
        }
    }
    @Test
    public void Test1() {
        String filePath = "src/test/java/com/example/demo/controller/国内航班测试用例.json";
        String jsonContent = FileUtil(filePath);
        List<Calc> list = JSON.parseArray(jsonContent, Calc.class);
        UnitTest(list);
    }
    @Test
    public void Test2() {
        String filePath = "src/test/java/com/example/demo/controller/国际航班测试用例.json";
        String jsonContent = FileUtil(filePath);
        List<Calc> list = JSON.parseArray(jsonContent, Calc.class);
        UnitTest(list);
    }

}
