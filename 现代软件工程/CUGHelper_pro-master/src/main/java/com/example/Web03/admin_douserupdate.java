package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_douserupdate")
public class admin_douserupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
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
        String userstatus = req.getParameter("userstatus");
        int status=1;
        if (userstatus!=null){
            status=Integer.parseInt(userstatus);
        }

        USER_TABLE user = new USER_TABLE(username,name,password,sex,birthday,null,email,phone,address,status);

        int count= userdatebase.update(user);

        if(count>0){
            resp.sendRedirect("admin_douserselect?cp="+req.getParameter("cpage"));
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户修改失败');");
            writer.write("location.href='admin_touserupdate?id="+username+"'");
            writer.write("</script>");
        }


    }
}
