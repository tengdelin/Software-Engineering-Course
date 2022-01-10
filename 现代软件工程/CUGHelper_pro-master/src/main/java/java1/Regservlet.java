package java1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/servletReg")
public class Regservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("姓名");
        String phone = req.getParameter("手机号");
        String email = req.getParameter("邮箱");
        String password = req.getParameter("密码");

        USER_TABLE user = new USER_TABLE(name,phone,email,password);

        int count = userdatabase.insert(user);
        if(count>0){
            resp.sendRedirect("login.jsp");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户添加失败');");
            writer.write("location.href='reg.jsp';");
            writer.write("</script>");
        }
    }
}
