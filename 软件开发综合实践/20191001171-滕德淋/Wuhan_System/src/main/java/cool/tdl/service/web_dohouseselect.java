package cool.tdl.service;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.house;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/web_dohouseselect")
public class web_dohouseselect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String keyword = req.getParameter("keywords");
        ArrayList<house> list = housedatebase.admin_select_house(keyword);
        req.setAttribute("houselist",list);
        req.setAttribute("keyword",keyword);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
