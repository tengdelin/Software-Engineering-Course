package cool.tdl.servlet;

import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;
import cool.tdl.pojo.icon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/web_usericon_servlet")
public class web_usericon_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        icon i = userdatebase.select_iconname(userid);
        HttpSession session = req.getSession();
        session.setAttribute("icon",i);
        resp.sendRedirect("/Wuhan_System/grxx.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
