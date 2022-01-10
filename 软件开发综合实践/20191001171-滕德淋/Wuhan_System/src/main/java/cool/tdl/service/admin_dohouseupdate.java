package cool.tdl.service;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;
import cool.tdl.pojo.house;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 房源修改功能
 */
@WebServlet("/manage/admin_dohouseupdate")
public class admin_dohouseupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String huxin=req.getParameter("huxin");
        int totalprize= Integer.parseInt(req.getParameter("totalprize"));
        int avgprize= Integer.parseInt(req.getParameter("avgprize"));
        int allarea= Integer.parseInt(req.getParameter("allarea"));
        String innerarea=req.getParameter("innerarea");
        String chaoxiang=req.getParameter("chaoxiang");
        String name=req.getParameter("name");
        String floor=req.getParameter("floor");
        String allfloor=req.getParameter("allfloor");
        String year=req.getParameter("year");
        String neixin=req.getParameter("neixin");
        int fid= Integer.parseInt(req.getParameter("fid"));
        house h=new house(fid,huxin,totalprize,avgprize,allarea,innerarea,chaoxiang,name,floor,allfloor,year,neixin);
        boolean flag= housedatebase.admin_update_house(h);
        PrintWriter writer = resp.getWriter();
        if(flag){
            writer.write("<script>");
            writer.write("alert('用户修改成功!');");
            writer.write("</script>");
            resp.sendRedirect("admin_dohouseselect?cp="+req.getParameter("cpage"));
        }else{
            writer.write("<script>");
            writer.write("alert('用户修改失败');");
            writer.write("location.href='admin_tohouseupdate?id="+fid+"'");
            writer.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
