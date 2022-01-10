package com.example.Web03;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter("/web_reg")
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req=(HttpServletRequest)request;//转换类型
        HttpServletResponse resp=(HttpServletResponse)response;

        String userName = req.getParameter("userName");

        PrintWriter out = resp.getWriter();
        if (userName.equals("")){
            out.write("<script>");
            out.write("alert('用户名不能为空');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
            return;
        }
        HttpSession session =req.getSession();
        String verycode = req.getParameter("code");
        String sysCode = (String) session.getAttribute("code");

        if (!sysCode.equals(verycode)){
            out.write("<script>");
            out.write("alert('验证码错误');");
            out.write("location.herf='reg.jsp';");
            out.write("</script>");
            out.close();
            return;
        }
        chain.doFilter(req, resp);
    }
}
