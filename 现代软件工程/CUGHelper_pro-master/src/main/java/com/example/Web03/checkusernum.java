package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkusernum")
public class checkusernum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String num =req.getParameter("num");
        HttpSession session = req.getSession();
        String sysCode = (String) session.getAttribute("code");

        PrintWriter out = resp.getWriter();
//        System.out.println(num);
//        System.out.println(sysCode);
        if (sysCode.equals(num)){
            out.print("true");
        }else {
            out.print("false");
        }
        out.close();
    }
}
