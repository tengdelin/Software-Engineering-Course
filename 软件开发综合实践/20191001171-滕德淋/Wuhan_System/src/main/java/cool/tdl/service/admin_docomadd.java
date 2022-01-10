package cool.tdl.service;

import cool.tdl.dao.comdatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;
import cool.tdl.pojo.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 添加评论功能，回复评论
 */
@WebServlet("/manage/admin_docomadd")
public class admin_docomadd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String re_commend=req.getParameter("re_commend");
        int house_fid= Integer.parseInt(req.getParameter("house_fid"));

        int fid= Integer.parseInt(req.getParameter("fid"));

        com c=new com(1,re_commend,fid,house_fid);
        int count= comdatebase.insert_recom(c);

        PrintWriter writer = resp.getWriter();
        if(count!=0){
            writer.write("<script>");
            writer.write("alert('回复评论成功!');");
            writer.write("</script>");
            resp.sendRedirect("admin_docomselect?cp="+req.getParameter("cpage"));
        }else{
            writer.write("<script>");
            writer.write("alert('回复失败');");
            writer.write("location.href='admin_tocomadd?id="+fid+"'");
            writer.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
