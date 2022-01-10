package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_douserdel")
public class admin_douserdel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String ids[] = req.getParameterValues("id[]");

        for(int i=0;i<ids.length;i++){
            userdatebase.delete(ids[i]);
        }
        resp.sendRedirect("admin_douserselect");

//            PrintWriter writer = resp.getWriter();
//            writer.write("<script>");
//            writer.write("alert('用户删除失败');");
//            writer.write("location.href='admin_douserselect?cp="+req.getParameter("cpage")+"';");
//            writer.write("</script>");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");

        int count= userdatebase.delete(id);

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
