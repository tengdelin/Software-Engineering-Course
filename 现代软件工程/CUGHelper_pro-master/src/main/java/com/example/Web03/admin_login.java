package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_login")
public class admin_login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        USER_TABLE user = new USER_TABLE(username, password);//初始化对象
        int count = userdatebase.selectlogin(user);//查找对象


        if (count != 0) {
            //获取所有用户记录
            HttpSession session = req.getSession();
            USER_TABLE usered = userdatebase.selectadmin(username, password);
            session.setAttribute("name", usered);
            session.setAttribute("isLogin", "1");
            if (usered.getUSER_STATUS() == 1) {
                usered.setUSER_IDENITY_CODE("用户");
            } else {
                usered.setUSER_IDENITY_CODE("管理员");
            }
            resp.sendRedirect("/Web03/manage/admin_index.jsp");


//            //获取所有用户记录
//            req.setAttribute("username", username);
//            req.setAttribute("password", password);
//            req.getRequestDispatcher("admin_index.jsp").forward(req, resp);
////            resp.sendRedirect("index.jsp");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write(
                    "<script> " +
                            "alert('登录失败'); " +
                            "location.href='/Web03/manage/admin_login.jsp'; " +
                            "</script>");
        }
    }
}

