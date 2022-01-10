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
    <title>编辑</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="container clearfix">
    <div class="main-wrap">
        <div class="result-wrap">
            <div class="result-content">
                <form action="/Wuhan_System/web_douserupdate" method="post" id="myform" name="myform">
                    <input type="hidden" name="userstatus" value="${user.USER_STATUS}">
                    <table class="insert-tab" width="60%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户名</th>
                            <td>
                                <input class="common-text required" id="title" name="username" size="50"
                                       value="${user.USER_ID}"
                                       type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>用户姓名</th>
                            <td>
                                <input class="common-text required" id="title" name="name" size="50"
                                       value="${user.USER_NAME}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>登录密码</th>
                            <td>
                                <input class="common-text required" id="title" name="password" size="50"
                                       value="${user.USER_PASSWORD}"
                                       type="text">
                            </td>
                        </tr>

                        <tr>
                            <th>性别</th>
                            <td>
                                <input type="radio" name="sex" value="T" ${user.USER_SEX=='T'?"checked":""}>男
                                <input type="radio" name="sex" value="F" ${user.USER_SEX=='F'?"checked":""}>女
                            </td>
                        </tr>
                        <tr>
                            <th>出生日期</th>
                            <td><input class="common-text" name="birthday" size="50" value="${user.USER_BIRTHDAY}"
                                       type="text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>电子邮箱</th>
                            <td>
                                <input class="common-text required" id="title" name="email" size="50"
                                       value="${user.USER_EMAIL}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>联系电话</th>
                            <td>
                                <input class="common-text required" id="title" name="phone" size="50"
                                       value="${user.USER_MOBILE}" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>地址</th>
                            <td>
                                <input class="common-text required" id="title" name="address" size="50"
                                       value="${user.USER_ADDRESS}"
                                       type="text">
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
