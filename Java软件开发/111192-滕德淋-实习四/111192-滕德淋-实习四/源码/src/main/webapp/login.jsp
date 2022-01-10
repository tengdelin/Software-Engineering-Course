<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/15
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="/Web03/web_login" method="post">
        <h1>
            <a href="index.html">
                <img src="img/temp/logo.png">
            </a>
        </h1>
        <p><input type="text" name="userName" value="" placeholder="用户名"></p>
        <p><input type="password" name="passWord" value="" placeholder="密码"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt">
            <a class="" href="reg.jsp">免费注册</a>
            <a href="forget.jsp">忘记密码？</a>
        </p>
    </form>
</div>
</body>
</html>
