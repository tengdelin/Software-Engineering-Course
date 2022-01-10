package cool.tdl.servlet;

import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改用户信息的时候，先找到该用户信息
 */
@WebServlet("/manage/admin_touserupdate")
public class admin_touserupdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        //通过ID到数据里查找
        USER_TABLE user = userdatebase.selectbyId(id);
        req.setAttribute("user",user);
        req.setAttribute("cpage",req.getParameter("cpage"));
        req.getRequestDispatcher("admin_usermodify.jsp").forward(req,resp);
    }
}
