package cool.tdl.service;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 房源删除功能，包括批量删除
 */
@WebServlet("/manage/admin_dohousedel")
public class admin_dohousedel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String ids[] = req.getParameterValues("id[]");
        for (int i = 0; i < ids.length; i++) {
            housedatebase.admin_delete_house(ids[i]);
        }
        resp.sendRedirect("admin_dohouseselect");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        int count = housedatebase.admin_delete_house(id);
        if (count > 0) {
            resp.sendRedirect("admin_dohouseselect?cp=" + req.getParameter("cpage"));
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户删除失败');");
            writer.write("location.href='admin_dohouseselect?cp=" + req.getParameter("cpage") + "';");
            writer.write("</script>");
        }
    }
}
