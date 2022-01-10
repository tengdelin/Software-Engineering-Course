package cool.tdl.servlet;

import cool.tdl.dao.comdatebase;
import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.Something;
import cool.tdl.pojo.home;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 未使用该类，原始功能是想用来加载第二级数据，从而减少登录的时候的时间
 */
@WebServlet("/index2_servlet")
public class index2_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取第二级图标数据
        ArrayList<home> hlist= housedatebase.select_home_info();
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
            somethings1[i]=new Something(hlist.get(i).getName(),"1",longitude,latitude,count1[i]);
//            somethings1[i]=new Something(hlist.get(i).getName(),"1",longitude,latitude,"1");

        }



        JSONObject jsonObject1 = null;
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i < hlist.size(); i++) {
            jsonObject1 = JSONObject.fromObject(somethings1[i]);
            jsonArray1.add(jsonObject1);
        }


        HttpSession session = req.getSession();
//        session.setAttribute("array", jsonArray);
        session.setAttribute("array1",jsonArray1);
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
