package cool.tdl.service;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;
import cool.tdl.pojo.house;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 房源查找功能，可以直接全部筛选，也可以关键字搜索
 */
@WebServlet("/manage/admin_dohouseselect")
public class admin_dohouseselect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int cpage = 1;
        int count = 10;
        String cp = req.getParameter("cp");
        String keyword = req.getParameter("keywords");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        int arr[] = housedatebase.totalPage_house(count, keyword);
        //获取所有用户记录
        ArrayList<house> list = housedatebase.selectall_house(cpage, count, keyword);
        //放到请求对象域里
        req.setAttribute("houselist", list);
        req.setAttribute("tsum", arr[0]);
        req.setAttribute("tpage", arr[1]);
        req.setAttribute("cpage", cpage);
        req.setAttribute("keyword", keyword);
        if (keyword != null) {
            req.setAttribute("searchParams", "&keywords=" + keyword);
        }
        req.getRequestDispatcher("admin_house.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
