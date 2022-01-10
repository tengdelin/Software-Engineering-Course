<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/5/30
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body>


</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3>
                <a href="index.jsp">
                    <img src="img/icon/${icon.iconname}"/>
                </a>
                <p class="clearfix">
                    <span class="fl">${name.USER_NAME}</span>
                    <span class="fr">
                        <a href="/Wuhan_System/web_logout">[退出登录]</a>
                    </span>
                </p>
            </h3>
        </div>
        <div class="you fl"><h2>个人信息</h2>
            <div class="gxin">
                <div class="tx">
                    <a href="web_iconmodify.jsp?userfid=${name.USER_ID}">
                        <img src="img/icon/${icon.iconname}"/>
                        <p id="avatar">修改头像</p>
                    </a>
                </div>
                <div class="xx"><h3 class="clearfix"><strong class="fl">基础资料</strong>
                    <a href="/Wuhan_System/web_touserupdate?id=${name.USER_ID}" class="fr" id="edit1">编辑</a>
                </h3>
                    <div>用户名：${name.USER_ID}</div>
                    <div>姓名：${name.USER_NAME}</div>
                    <div>密码：用户不可见</div>
                    <div>生日：${name.USER_BIRTHDAY}</div>
                    <div>性别：${name.USER_SEX}</div>
                    <div>用户身份：${name.USER_IDENITY_CODE}</div>
                    <div>邮箱：${name.USER_EMAIL}</div>
                    <div>电话：${name.USER_MOBILE}</div>
                    <div>地址：${name.USER_ADDRESS}</div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
