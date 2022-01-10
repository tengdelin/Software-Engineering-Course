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

@WebServlet("/web_douserupdate")
public class web_douserupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
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

        boolean flag= userdatebase.admin_update_user(user);




        PrintWriter writer = resp.getWriter();
        if(flag){
            HttpSession session = req.getSession();
            session.setAttribute("name", user);//在jsp中name就是一个实体

            writer.write("<script>");
            writer.write("alert('用户修改成功!');");
            writer.write("</script>");
            resp.sendRedirect("grxx.jsp");
        }else{
            writer.write("<script>");
            writer.write("alert('用户修改失败');");
            writer.write("location.href='web_touserupdate?id="+username+"'");
            writer.write("</script>");
        }
    }
}
