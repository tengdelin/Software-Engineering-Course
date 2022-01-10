package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_douserselect")
public class admin_DoUserSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        int cpage = 1;
        int count = 5;
        String cp = req.getParameter("cp");
        String keyword = req.getParameter("keywords");
        if (cp!=null){
            cpage=Integer.parseInt(cp);
        }
        int arr[] = userdatebase.totalPage(count,keyword);

        //获取所有用户记录
        ArrayList<USER_TABLE>list = userdatebase.selectall(cpage,count,keyword);
        //放到请求对象域里
        req.setAttribute("userlist",list);
        req.setAttribute("tsum",arr[0]);
        req.setAttribute("tpage",arr[1]);
        req.setAttribute("cpage",cpage);
        req.setAttribute("keyword",keyword);

        if (keyword!=null){
            req.setAttribute("searchParams","&keywords="+keyword);
        }
        req.getRequestDispatcher("admin_user.jsp").forward(req,resp);
    }
}
