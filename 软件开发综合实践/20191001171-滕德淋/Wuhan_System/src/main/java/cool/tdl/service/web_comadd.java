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
 * 用户评论添加
 */
@WebServlet("/web_docomadd")
public class web_comadd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String commend=req.getParameter("commend");
        int house_fid= Integer.parseInt(req.getParameter("house_fid"));


        com c=new com(1,commend,0,house_fid);
        int count= comdatebase.insert_com(c);

        PrintWriter writer = resp.getWriter();
        if(count!=0){
            writer.write("<script>");
            writer.write("alert('评论成功!');");
            writer.write("</script>");
            resp.sendRedirect("/Wuhan_System/web_select_com?housefid="+house_fid+"");
        }else{
            writer.write("<script>");
            writer.write("alert('评论失败');");
            writer.write("location.href='/Wuhan_System/web_select_com?housefid="+house_fid+"'");
            writer.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
