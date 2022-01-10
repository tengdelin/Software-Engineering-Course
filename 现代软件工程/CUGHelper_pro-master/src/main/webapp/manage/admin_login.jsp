<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/29
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>后台管理登录</title>
  <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<body>
<div class="admin_login_wrap">
  <h1>后台管理登录</h1>
  <div class="adming_login_border">
    <div class="admin_input">
      <form action="/Web03/manage/admin_login" method="post">
        <ul class="admin_items">
          <li>
            <label for="user">用户名：</label>
            <input type="text" name="username" value="" id="user" size="40" class="admin_input_style" />
          </li>
          <li>
            <label for="pwd">密码：</label>
            <input type="password" name="pwd" value="" id="pwd" size="40" class="admin_input_style" />
          </li>
          <li>
            <input type="submit" tabindex="3" value="提交" class="btn btn-primary"/>
          </li>
        </ul>
      </form>
    </div>
  </div>
<%--  <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> &copy; 2014 Powered by 更多模板：<a href="http://www.lmonkey.com/" target="_blank">学习猿地</a></p>--%>
</div>
</body>
</html>