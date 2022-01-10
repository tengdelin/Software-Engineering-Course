package cool.tdl.service;

import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户修改功能
 */
@WebServlet("/manage/admin_douserupdate")
public class admin_douserupdate extends HttpServlet {
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
        if(flag){
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户修改成功!');");
            writer.write("</script>");
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
