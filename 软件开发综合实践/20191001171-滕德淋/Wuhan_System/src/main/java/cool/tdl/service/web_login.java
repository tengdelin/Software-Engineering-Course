package cool.tdl.service;

import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/web_login")
public class web_login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("userName");
        String password = req.getParameter("passWord");
        USER_TABLE user = new USER_TABLE(username, password);//初始化对象
        int count = userdatebase.weblogin(user);//查找对象
        if (count != 0) {
            //获取所有用户记录
            HttpSession session = req.getSession();
            USER_TABLE usered = userdatebase.admin_select_user(username);

            session.setAttribute("name", usered);//在jsp中name就是一个实体
            session.setAttribute("isLogin", "1");

            if (usered.getUSER_STATUS() == 1) {
                usered.setUSER_IDENITY_CODE("用户");
            } else if (usered.getUSER_STATUS() == 2) {
                usered.setUSER_IDENITY_CODE("企业人员");
            } else {
                usered.setUSER_IDENITY_CODE("管理员");
            }
            resp.sendRedirect("/Wuhan_System/index_servlet");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write(
                    "<script> " +
                            "alert('登录失败'); " +
                            "location.href='/Wuhan_System/login.jsp'; " +
                            "</script>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
