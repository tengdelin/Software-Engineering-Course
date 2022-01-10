<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/15
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    <script src="js/jquery-1.12.4.min.js"></script>

    <style>
        .reg p .error {
            display: inline-block;;
            border: 1px solid #ff855a;
            background-color: #ffe8e0;
            height: 25px;
            line-height: 25px;
            padding: 0px 20px;
            margin-left: 20px;
        }
    </style>

</head>
<body>
<!-------------------reg-------------------------->
<div class="reg">
    <form action="/Web03/web_reg" method="post" onsubmit="return checkForm(this)">
        <h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p>
        <h1 style="padding: 0px;margin: 0px;font-size: 20px;background: rgb(193,0,0);text-align: center;line-height: 30px;color: #FFFFFF">
            用户注册</h1></p>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="relname" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入姓名"><span></span></p>
        <p><input type="password" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入密码"><span></span></p>
        <p><input type="password" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请确认密码"><span></span></p>
        <p>
            <input style=" width: 15px;height: 15px; text-align: left" type="radio" name="sex" value="T"
                   checked="checked">男
            <input style=" width: 15px;height: 15px; text-align: left" type="radio" name="sex" value="F"
            >女
        </p>
        <p><input type="date" name="birthday" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入出生日期"><span></span></p>
        <p><input type="email" name="email" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入邮箱"><span></span></p>
        <p><input type="tel" name="mobile" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="address" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                  placeholder="请输入地址"><span></span></p>
        <p>
            <input class="code" type="text" name="code" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"
                   placeholder="验证码">
            <img src="getcode" alt="看不清，换一张" onclick="change(this)"><span></span>
        </p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txt">
            <a href="login.jsp"><span>已有账号登录</span></a>
        </p>
    </form>
</div>
</body>
</html>
