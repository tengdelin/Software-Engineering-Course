package cool.tdl.service;

import cool.tdl.dao.userdatebase;
import cool.tdl.dao.zhoubiandatebase;
import cool.tdl.pojo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/web_distance")
public class web_distance extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String keyword = req.getParameter("homefid");
        ArrayList<home_by_park> list = zhoubiandatebase.selectall_park_distance(keyword);
        ArrayList<home_by_shop> list1 = zhoubiandatebase.selectall_shop_distance(keyword);
        ArrayList<home_by_school> list2 = zhoubiandatebase.selectall_school_distance(keyword);
        ArrayList<home_by_hospital> list3 = zhoubiandatebase.selectall_hospital_distance(keyword);
        ArrayList<home_by_transportandroad> list4 = zhoubiandatebase.selectall_transportandroad_distance(keyword);

        req.setAttribute("home_by_park_list",list);
        req.setAttribute("home_by_shop_list",list1);
        req.setAttribute("home_by_school_list",list2);
        req.setAttribute("home_by_hospital_list",list3);
        req.setAttribute("home_by_transportandroad_list",list4);

        req.setAttribute("keyword",keyword);
        req.getRequestDispatcher("distance.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
