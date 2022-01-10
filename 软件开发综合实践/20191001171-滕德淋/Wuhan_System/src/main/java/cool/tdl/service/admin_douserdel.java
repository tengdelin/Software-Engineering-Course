package cool.tdl.service;

import cool.tdl.dao.userdatebase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户删除功能
 */
@WebServlet("/manage/admin_douserdel")
public class admin_douserdel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String ids[] = req.getParameterValues("id[]");

        for(int i=0;i<ids.length;i++){
            userdatebase.admin_delete_user(ids[i]);
        }
        resp.sendRedirect("admin_douserselect");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        int count= userdatebase.admin_delete_user(id);
        if(count>0){
            resp.sendRedirect("admin_douserselect?cp="+req.getParameter("cpage"));
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户删除失败');");
            writer.write("location.href='admin_douserselect?cp="+req.getParameter("cpage")+"';");
            writer.write("</script>");
        }
    }
}
