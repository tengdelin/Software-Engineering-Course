<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/13
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="admin_menu.jsp" %>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用武汉房源查找管理平台</span></div>
    </div>
<%--    <div class="result-wrap">--%>
<%--        <div class="result-title">--%>
<%--            <h1>快捷操作</h1>--%>
<%--        </div>--%>
<%--        <div class="result-content">--%>
<%--            <div class="short-wrap">--%>
<%--                <a href="/Wuhan_System/manage/admin_douserselect"><i class="icon-font">&#xe001;</i>用户管理</a>--%>
<%--                <a href="admin_useradd.jsp"><i class="icon-font">&#xe005;</i>用户添加</a><br>--%>
<%--                <a href="/Wuhan_System/manage/admin_dohouseselect"><i class="icon-font">&#xe001;</i>房源管理</a>--%>
<%--                <a href="admin_houseadd.jsp"><i class="icon-font">&#xe005;</i>房源添加</a>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="result-wrap">
        <div class="result-title">
            <h1>平台基本信息</h1>
        </div>
        <div class="result-content">
            <ul class="sys-info-list">
                <li>
                    <label class="res-lab">平台维护</label><span class="res-info">小滕</span>
                </li>
                <li>
                    <label class="res-lab">项目来源</label><span class="res-info">数据库课程实习、Java课程实习</span>
                </li>
                <li>
                    <label class="res-lab">涉及知识</label><span class="res-info">数据库设计、JavaWeb、前端UI</span>
                </li>

            </ul>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-title">
            <h1>联系我们</h1>
        </div>
        <div class="result-content">
            <ul class="sys-info-list">
                <li>
                    <label class="res-lab">联系小滕：</label><span class="res-info">
                    <a href="http://web2.tdl.cool/" target="_blank">小滕主页</a></span>
                </li>
            </ul>
        </div>
    </div>
</div>
</div>
</body>
</html>
