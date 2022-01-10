<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/13
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理界面</title>
    <link rel="stylesheet" type="text/css" href="/Wuhan_System/css/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/Wuhan_System/css/css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="admin_index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">管理平台首页</a></li>
                <li><a href="/Wuhan_System/index.jsp" target="">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="">${name.USER_IDENITY_CODE}</a></li>
                <li><a href="">${name.USER_NAME}</a></li>
                <li><a href="/Wuhan_System/manage/adminlogout">退出</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/Wuhan_System/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="/Wuhan_System/manage/admin_dohouseselect"><i class="icon-font">&#xe008;</i>房源管理</a></li>
                        <li><a href="/Wuhan_System/manage/admin_readhouse"><i class="icon-font">&#xe008;</i>房源查询</a></li>
                        <li><a href="/Wuhan_System/manage/admin_docomselect"><i class="icon-font">&#xe008;</i>评论回复</a></li>

<%--                        <li><a href="/Wuhan_System/manage/admin_cateselect"><i class="icon-font">&#xe008;</i>分类管理</a></li>--%>
<%--                        <li><a href="/Wuhan_System/manage/admin_productselect"><i class="icon-font">&#xe008;</i>悬赏管理</a></li>--%>
<%--                        <li><a href="admin_useradd.jsp"><i class="icon-font">&#xe005;</i>用户添加</a></li>--%>
<%--                        <li><a href="admin_usermodify.jsp"><i class="icon-font">&#xe006;</i>用户修改</a></li>--%>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

