package cool.tdl.servlet;

import cool.tdl.dao.comdatebase;
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

/**
 * 要修改房源信息的时候，先查找到该房源的信息
 */
@WebServlet("/manage/admin_tohouseupdate")
public class admin_tohouseupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        //通过ID到数据里查找
        house h = housedatebase.selectall_house_key_fid(id);
        req.setAttribute("h",h);
        req.setAttribute("cpage",req.getParameter("cpage"));
        req.getRequestDispatcher("admin_housemodify.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
