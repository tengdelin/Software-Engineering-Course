package cool.tdl.test;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.Something;
import cool.tdl.pojo.home;

import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) {
        //获取第二级图标数据
        ArrayList<home> hlist = housedatebase.select_home_info();
        Something[] somethings1 = new Something[hlist.size()];

        for (int i = 0; i < hlist.size(); i++) {
            String longitude = "";
            String latitude = "";
            String temp = "";
            temp = hlist.get(i).getPoint();
            temp=temp.substring(5);
            boolean flag=true;
            for (int j=1;j<temp.length();j++){
                if (temp.charAt(j)==')'){
                    break;
                }
                if (temp.charAt(j)==' '){
                    flag=false;
                }
                if (flag){
                    longitude+=temp.charAt(j);
                }else {
                    latitude+=temp.charAt(j);
                }
            }

        }
        System.out.println();
    }
}
