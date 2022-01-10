package com.example.Web03;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/manage/*")
public class Filter2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpServletRequest req = (HttpServletRequest) request;//转换类型
        HttpServletResponse resp = (HttpServletResponse) response;
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String flag = (String) session.getAttribute("adminisLogin");
//        System.out.println(flag);
        String request_uri = req.getRequestURI();
        String ctxpath = req.getContextPath();
        String uri = request_uri.substring(ctxpath.length());
        if (uri.contains("admin_")) {
            if (flag != null && flag.equals("1")) {
                chain.doFilter(req, resp);
            } else {
                out.write("<script>");
                out.write("alert('请先登录！');");
                out.write("location.href='login.jsp';");
                out.write("</script>");
            }
        } else {
            chain.doFilter(req, resp);
        }
    }
}
