package cool.tdl.service;

//import org.graalvm.compiler.serviceprovider.IsolateUtil;

import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.USER_TABLE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 后台管理系统登录功能实现函数
 * 获取用户名和密码
 */
@WebServlet("/manage/adminlogin")
public class admin_login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");

        USER_TABLE user = new USER_TABLE(username, password);//初始化对象
        int count = userdatebase.selectlogin(user);//查找对象

        if (count > 0) {
            //获取所有用户记录
            HttpSession session = req.getSession();
            USER_TABLE usered = userdatebase.admin_select_user(username);
            session.setAttribute("name", usered);
            //session.setAttribute("isLogin", "1");
            session.setAttribute("adminisLogin", "1");

            if (usered.getUSER_STATUS() == 1) {
                usered.setUSER_IDENITY_CODE("用户");
            } else if(usered.getUSER_STATUS()==2) {
                usered.setUSER_IDENITY_CODE("企业人员");
            }else {
                usered.setUSER_IDENITY_CODE("管理员");
            }
            resp.sendRedirect("/Wuhan_System/manage/admin_index.jsp");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write("<script> ");
            writer.write("alert('登录失败,只有管理员或者企业人员才能登录');" );
            writer.write( "location.href='/Wuhan_System/manage/login.jsp';");
            writer.write("</script> ");
        }
    }
}

