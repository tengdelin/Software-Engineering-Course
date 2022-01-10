package cool.tdl.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/web_logout")
public class web_logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session=req.getSession();
        session.removeAttribute("isLogin");
        session.removeAttribute("adminisLogin");
        session.removeAttribute("name");
        session.removeAttribute("array");
        session.removeAttribute("array1");

        resp.sendRedirect("index.jsp");
    }
}
