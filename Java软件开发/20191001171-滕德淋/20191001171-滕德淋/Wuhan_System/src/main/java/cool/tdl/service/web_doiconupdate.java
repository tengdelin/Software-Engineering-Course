package cool.tdl.service;

import com.jspsmart.upload.*;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.icon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/web_doiconupdate")
public class web_doiconupdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), req, resp);
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Files fs = su.getFiles();
        File f = fs.getFile(0);
        String iconname = f.getFileName();
        try {
//            su.save("C:\\Users\\滕德淋\\IdeaProjects\\Wuhan_System\\Wuhan_System\\src\\main\\webapp\\img\\icon");
            su.save("img/icon");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request request = su.getRequest();
        String userfid = request.getParameter("userfid");
        icon i = new icon(userfid, iconname);
        int count = userdatebase.insert_icon(i);
        PrintWriter writer = resp.getWriter();
        if (count != 0) {
            writer.write("<script>");
            writer.write("alert('上传成功');");
            writer.write("location.href='/Wuhan_System/web_usericon_servlet?userid=" + userfid + "';");
            writer.write("</script>");
        } else {
            writer.write("<script>");
            writer.write("alert('上传失败');");
            writer.write("location.href='web_iconmodify.jsp';");
            writer.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
