package java1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/loginServlet")
public class loginservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("姓名");
        String phone = req.getParameter("手机号");
//        String email = req.getParameter("邮箱");
        String password = req.getParameter("密码");


        USER_TABLE user = new USER_TABLE(name,phone,password);//初始化对象

        int count = userdatabase.select(user);//查找对象

        if(count>0){
            //获取所有用户记录
            req.setAttribute("name",name);
            req.setAttribute("phone",phone);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
//            resp.sendRedirect("index.jsp");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script> alert('登录失败'); location.href='/CUGhelper/login.jsp'; </script>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
            String name = req.getParameter("姓名");
            String phone = req.getParameter("手机号");

//获取所有用户记录
            req.setAttribute("姓名",name);
            req.setAttribute("手机号",phone);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
