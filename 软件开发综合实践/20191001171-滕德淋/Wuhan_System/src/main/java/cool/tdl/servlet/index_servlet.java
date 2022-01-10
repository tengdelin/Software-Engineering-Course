package cool.tdl.servlet;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.Something;
import cool.tdl.pojo.home;
import cool.tdl.test.Test4;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 首页加载地图数据
 */
@WebServlet("/index_servlet")
public class index_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取行政区数据，第一级图标
        String xzname[]={"江岸区","江汉区","武昌区","硚口区","汉阳区","青山区","洪山区",
                "蔡甸区","江夏区","黄陂区","新洲区","东西湖区","汉南区"};
        String[] count= housedatebase.select_xzcount(xzname);
        Something[] somethings = new Something[13];
        somethings[0] = new Something("江岸区", "410100000", "114.313436", "30.606164", count[0]);
        somethings[1] = new Something("江汉区", "410200000", "114.261694", "30.618099", count[1]);
        somethings[2] = new Something("武昌区", "410300000", "114.320623", "30.559404", count[2]);
        somethings[3] = new Something("硚口区", "410400000", "114.223184", "30.587335", count[3]);
        somethings[4] = new Something("汉阳区", "410500000", "114.224297", "30.561295", count[4]);
        somethings[5] = new Something("青山区", "410600000", "114.386316", "30.648333", count[5]);
        somethings[6] = new Something("洪山区", "410700000", "114.349306", "30.506584", count[6]);
        somethings[7] = new Something("蔡甸区", "410800000", "114.036633", "30.588362", count[7]);
        somethings[8] = new Something("江夏区", "410900000", "114.329705", "30.382809", count[8]);
        somethings[9] = new Something("黄陂区", "411000000", "114.381303", "30.889268", count[9]);
        somethings[10] = new Something("新洲区", "411100000", "114.803516", "30.847988", count[10]);
        somethings[11] = new Something("东西湖区", "411200000", "114.145759", "30.62766", count[11]);
        somethings[12] = new Something("汉南区", "411300000", "114.097268", "30.314559", count[12]);

        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 13; ++i) {
            jsonObject = JSONObject.fromObject(somethings[i]);
            jsonArray.add(jsonObject);
        }

        //获取第二级图标数据
        ArrayList<home> hlist=housedatebase.select_home_info();
        Something[] somethings1 = new Something[hlist.size()];
        String count1[]=housedatebase.select_house_home_count(hlist);

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

            Test4.MapSubject x0y0 = new Test4.MapSubject(25.974999999999998, 119.21166666666667,
                    25.9776145157, 119.2230386554);
            Test4.MapSubject x1y0 = new Test4.MapSubject(26.105833333333333, 119.21166666666667,
                    26.1083582702, 119.2230388300);
            Test4.MapSubject x1y1 = new Test4.MapSubject(26.105833333333333, 119.36166666666666,
                    26.1087320550, 119.3731015851);
            Test4.MapSubject x0y1 = new Test4.MapSubject(25.974999999999998, 119.36166666666666,
                    25.9779880657, 119.3731014562);
            double tGpsLat= Double.parseDouble(longitude);
            double tGpsLng= Double.parseDouble(latitude);
            // 计算纠偏影响系数
            double param0 = (tGpsLat - x0y0.getBdLat())	* (tGpsLng - x0y0.getBdLng());
            double param1 = (x0y1.getBdLat() - tGpsLat)	* (tGpsLng - x0y1.getBdLng());
            double param2 = (x1y1.getBdLat() - tGpsLat)	* (x1y1.getBdLng() - tGpsLng);
            double param3 = (tGpsLat - x1y0.getBdLat())	* (x1y0.getBdLng() - tGpsLng);
            double tOffsetLat = x0y0.getOffsetLat() * param0 + x0y1.getOffsetLat() * param1
                    + x1y1.getOffsetLat() * param2 + x1y0.getOffsetLat() * param3;
            double tOffsetLng = x0y0.getOffsetLng() * param0 + x0y1.getOffsetLng() * param1
                    + x1y1.getOffsetLng() * param2 + x1y0.getOffsetLng() * param3;
            double tBdLat = tGpsLat + tOffsetLat + 0.003; //0.003 修正值.为多次测试比较后得到的一个近似的常量值
            double tBdLng = tGpsLng + tOffsetLng + 0.011; //同上
            longitude= String.valueOf(tBdLat);
            latitude= String.valueOf(tBdLng);
            somethings1[i]=new Something(hlist.get(i).getName(),hlist.get(i).getFid(),longitude,latitude,count1[i]);
//            somethings1[i]=new Something(hlist.get(i).getName(),"1",longitude,latitude,"1");
        }

        JSONObject jsonObject1 = null;
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i < hlist.size(); i++) {
            jsonObject1 = JSONObject.fromObject(somethings1[i]);
            jsonArray1.add(jsonObject1);
        }


        HttpSession session = req.getSession();
        session.setAttribute("somethings",somethings);
        session.setAttribute("somethings1",somethings1);

        session.setAttribute("array", jsonArray);
        session.setAttribute("array1",jsonArray1);
        resp.sendRedirect("index.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
