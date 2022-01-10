<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/13
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改头像</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="container clearfix">
    <div class="main-wrap">
        <div class="result-wrap">
            <div class="result-content">
                <form action="/Wuhan_System/web_doiconupdate" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="60%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户ID</th>
                            <td>
                                <%
                                String userfid=request.getParameter("userfid");
                                %>
                                <input type="text" name="userfid" value=<%=userfid%>>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>上传头像</th>
                            <td>
                                <input class="common-text required" name="photo" size="50" value=" " type="file">
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
