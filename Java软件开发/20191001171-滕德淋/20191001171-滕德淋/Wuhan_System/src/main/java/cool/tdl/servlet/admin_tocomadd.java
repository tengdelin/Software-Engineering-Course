package cool.tdl.servlet;

import cool.tdl.dao.comdatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 回复评论时先查找到该评论的信息
 */
@WebServlet("/manage/admin_tocomadd")
public class admin_tocomadd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        //通过ID到数据里查找
        com c = comdatebase.selectall_com_key_fid(id);
        req.setAttribute("c",c);
        req.setAttribute("cpage",req.getParameter("cpage"));
        req.getRequestDispatcher("admin_comadd.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
