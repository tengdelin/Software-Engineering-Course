package com.example.Web03;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_doproductadd1")
public class admin_doproductadd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=utf-8");
//        SmartUpload su = new SmartUpload();
//        su.initialize(getServletConfig(), req, resp);
//        //设置上传文件的最大值
//        su.setMaxFileSize(1024 * 1024 * 10);
//        //设置上传文件的总最大值
//        su.setTotalMaxFileSize(1024 * 1024 * 100);
//        //设置允许上传文件类型
//        su.setAllowedFilesList("jpg,gif,jpeg,png");
//        try {
//            su.upload();
//        } catch (SmartUploadException e) {
//            e.printStackTrace();
//        }
//        String name = su.getRequest().getParameter("productName"); //接收请求参数
//        System.out.println(name);
//        Files fs = su.getFiles();
//        File f=fs.getFile(0);
//        String fname = f.getFileName();
//        try {
//            su.save("testsrc/product");
//        } catch (SmartUploadException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(fname);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<script>");
        writer.write("alert('上传失败');");
        writer.write("location.href='admin_productadd.jsp';");
        writer.write("</script>");
    }
}
