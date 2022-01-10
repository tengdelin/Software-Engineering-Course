package com.example.Web03;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/manage/admin_douseradd")
public class admin_douseradd extends HttpServlet {
    public void init() {
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        USER_TABLE user = new USER_TABLE(username,name,password,sex,birthday,null,email,phone,address,1);

       int count= userdatebase.insert(user);

        if(count>0){
            resp.sendRedirect("admin_user.jsp");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户添加失败');");
            writer.write("location.href='admin_add.jsp';");
            writer.write("</script>");
        }
    }
    public void destroy() {
    }
}