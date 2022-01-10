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
    <title>${keyword}</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>

<body>


</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3>
                <a href="index.jsp"><img src="img/cug1.jpg"/></a>
            </h3>
        </div>
        <div class="you fl">
            <h2>${keyword}</h2>
            <div class="gxin">
                <div class="tx">
                    <a href="#">
                        <img src="img/cug1.jpg"/>
                        <p id="avatar">修改头像</p>
                    </a>
                </div>
                <div class="xx">
                    <h3 class="clearfix">
                        <strong class="fl">一共${houselist.size()}条信息</strong>
                    </h3>
                <c:forEach var="h" items="${houselist}">
                    <div>房源编号：${h.fid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Wuhan_System/web_select_com?housefid=${h.fid}" class="btn">查看评论</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Wuhan_System/web_distance?homefid=${homefid}" class="btn">查看周边</a>
                    </div>
                    <div>户型：${h.huxin}</div>
                    <div>总价：${h.totalprize}</div>
                    <div>平均价格：${h.avgprize}</div>
                    <div>建筑面积：${h.allarea}</div>
                    <div>室内面积：${h.innerarea}</div>
                    <div>房屋朝向：${h.chaoxiang}</div>
                    <div>所属小区：${h.name}</div>
                    <div>所在楼层：${h.floor}</div>
                    <div>总楼层：${h.allfloor}</div>
                    <div>所建年份：${h.year}</div>
                    <div>房屋类型：${h.neixin}</div>
                    <hr>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
