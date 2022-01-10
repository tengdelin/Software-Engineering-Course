package cool.tdl.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 后台注销登录功能
 */
@WebServlet("/manage/adminlogout")
public class admin_logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session=req.getSession();
        session.removeAttribute("adminisLogin");
        session.removeAttribute("isLogin");
        session.removeAttribute("name");
        session.removeAttribute("array");
        session.removeAttribute("array1");

        PrintWriter writer = resp.getWriter();
        writer.write("<script>");
        writer.write("alert('退出成功');");
        writer.write("location.href='login.jsp';");
        writer.write("</script>");
    }
}
