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
import java.util.ArrayList;

/**
 * 选择评论功能
 */
@WebServlet("/manage/admin_docomselect")
public class admin_docomselect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        int cpage = 1;
        int count = 20;
        String cp = req.getParameter("cp");
        String keyword = req.getParameter("keywords");
        if (keyword!=null){
            if (keyword.equals("")){
                keyword=null;
            }
        }
        if (cp!=null){
            cpage=Integer.parseInt(cp);
        }
        int arr[] = comdatebase.totalPage_com(count,keyword);

        //获取所有用户记录
        ArrayList<com> list = comdatebase.selectall_com(cpage,count,keyword);
        //放到请求对象域里
        req.setAttribute("comlist",list);
        req.setAttribute("tsum",arr[0]);
        req.setAttribute("tpage",arr[1]);
        req.setAttribute("cpage",cpage);
        req.setAttribute("keyword",keyword);

        if (keyword!=null){
            req.setAttribute("searchParams","&keywords="+keyword);
        }
        req.getRequestDispatcher("admin_com.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
