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
        <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用CUG大学生校园互助管理平台</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-title">
            <h1>快捷操作</h1>
        </div>
        <div class="result-content">
            <div class="short-wrap">
                <a href="/Web03/manage/admin_douserselect"><i class="icon-font">&#xe001;</i>用户管理</a>
                <a href="admin_add.jsp"><i class="icon-font">&#xe005;</i>用户添加</a>
                <a href="admin_usermodify.jsp"><i class="icon-font">&#xe048;</i>用户修改</a>
            </div>
        </div>
    </div>
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
                    <label class="res-lab">项目来源</label><span class="res-info">课内实习</span>
                </li>
                <li>
                    <label class="res-lab">小组人员</label><span class="res-info">滕德淋、刘世龙、赵文鹏、李受渊、彭志豪、田浩然</span>
                </li>
                <li>
                    <label class="res-lab">服务器域名/IP</label><span class="res-info">web1.tdl.cool [ 140.82.112.4 ]</span>
                </li>
                <li>
                    <label class="res-lab">Host</label><span class="res-info">140.82.112.4</span>
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
                    <label class="res-lab">联系小滕：</label><span class="res-info"><a href="http://my.tdl.cool/"
                                                                                  target="_blank">小滕导航</a></span>
                </li>
            </ul>
        </div>
    </div>
</div>
</div>
</body>
</html>
