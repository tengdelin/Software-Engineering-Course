package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 检查验证是否正确，返回true或者false到function函数中
 */
@WebServlet("/checkusernum")
public class checkusernum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String num =req.getParameter("num");//用户输入的验证码

        HttpSession session = req.getSession();
        String sysCode = (String) session.getAttribute("code");//后台生成的验证码
        PrintWriter out = resp.getWriter();
        if (sysCode.equals(num)){
            out.print("true");
        }else {
            out.print("false");
        }
        out.close();
    }
}
