package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexselect")
public class indexselect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        ArrayList<CATE_TABLE> flist = catedatebase.selectCat("father");
        req.setAttribute("flist", flist);

        ArrayList<CATE_TABLE> clist = catedatebase.selectCat("child");
        req.setAttribute("clist", clist);

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }


}
