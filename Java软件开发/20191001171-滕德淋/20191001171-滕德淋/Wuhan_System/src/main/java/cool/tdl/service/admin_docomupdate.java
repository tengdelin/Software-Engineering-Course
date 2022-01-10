package cool.tdl.service;

import cool.tdl.dao.comdatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 评论修改代码
 */
@WebServlet("/manage/admin_docomupdate")
public class admin_docomupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String commend=req.getParameter("commend");
        int house_fid= Integer.parseInt(req.getParameter("house_fid"));
        int parent_fid= Integer.parseInt(req.getParameter("parent_fid"));
        int fid= Integer.parseInt(req.getParameter("fid"));

        com c=new com(fid,commend,parent_fid,house_fid);
        boolean flag= comdatebase.admin_update_com(c);

        PrintWriter writer = resp.getWriter();
        if(flag){
            writer.write("<script>");
            writer.write("alert('评论修改成功!');");
            writer.write("</script>");
            resp.sendRedirect("admin_docomselect?cp="+req.getParameter("cpage"));
        }else{
            writer.write("<script>");
            writer.write("alert('评论修改失败');");
            writer.write("location.href='admin_tocomupdate?id="+fid+"'");
            writer.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
