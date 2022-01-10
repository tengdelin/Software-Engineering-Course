package cool.tdl.test;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;

public class Test2 {
    public static void main(String[] args) {
        String xzname[]={"江岸区","江汉区","武昌区","硚口区","汉阳区","青山区","洪山区",
                "蔡甸区","江夏区","黄陂区","新洲区","东西湖区","汉南区"};

        String[] num= housedatebase.select_xzcount(xzname);
        for (int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
    }
}
