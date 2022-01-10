package cool.tdl.service;

import cool.tdl.dao.comdatebase;
import cool.tdl.dao.userdatebase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 删除评论功能
 */
@WebServlet("/manage/admin_docomdel")
public class admin_docomdel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");

        int count = comdatebase.admin_delete_com(id);

        if (count > 0) {
            resp.sendRedirect("admin_docomselect?cp=" + req.getParameter("cpage"));
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户删除失败');");
            writer.write("location.href='admin_dohouseselect?cp=" + req.getParameter("cpage") + "';");
            writer.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
