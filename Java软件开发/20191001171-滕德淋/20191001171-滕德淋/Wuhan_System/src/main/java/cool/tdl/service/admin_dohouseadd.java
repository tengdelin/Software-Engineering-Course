package cool.tdl.service;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.house;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 房源添加功能
 */
@WebServlet("/manage/admin_dohouseadd")
public class admin_dohouseadd extends HttpServlet {
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

        house h=new house(1,huxin,totalprize,avgprize,allarea,innerarea,chaoxiang,name,floor,allfloor,year,neixin);
        int count= housedatebase.admin_insert_house(h);
        if(count>0){
            resp.sendRedirect("admin_dohouseselect");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('房源添加失败');");
            writer.write("location.href='admin_houseadd.jsp';");
            writer.write("</script>");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
