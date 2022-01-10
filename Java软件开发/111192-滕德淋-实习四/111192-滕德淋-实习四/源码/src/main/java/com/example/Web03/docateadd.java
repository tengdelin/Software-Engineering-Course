package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/admin_docateadd")
public class docateadd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int fid = Integer.parseInt(req.getParameter("parentId"));
        String name = req.getParameter("className");
        CATE_TABLE c = new CATE_TABLE(0,name,fid);
        catedatebase.insert(c);
        resp.sendRedirect("admin_cateselect");
    }
}
