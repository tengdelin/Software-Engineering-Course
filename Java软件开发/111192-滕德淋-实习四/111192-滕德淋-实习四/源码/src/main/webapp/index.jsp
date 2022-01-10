<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/15
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="utf-8" />
    <title>地大互助平台</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <!-- 自己写的css代码 -->
    <style>
        .tdl {
            background-color: #000000;
            width: 100%;
            height: 30px;
            color: #FFFFFF;
            font-size: 20px;
            font-weight: bolder;
        }
    </style>
</head>

<body>
<!------------------------------head------------------------------>
<%@include file="header.jsp"%>
<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner2.jpg" /></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner1.jpg" /></div>
            </li>
        </ul>
    </div>
</div>

<!-------------------------最新悬赏--------------------------->
<div class="tdl" align="center">
    最新悬赏
</div>
<div class="people">
    <div class="pList clearfix tran"><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s7.jpg" /><span class="abr"></span></dt>
            <dd>【学习天地】英语听力耳机</dd>
            <dd><span>￥68.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s10.jpg" /><span class="abr"></span></dt>
            <dd>【学习天地】毕业出自行车</dd>
            <dd><span>￥188.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s7.jpg" /><span class="abr"></span></dt>
            <dd>【代取快递】大件五元，小件三元（仅限未来城）</dd>
            <dd><span>￥5.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s9.jpg" /><span class="abr"></span></dt>
            <dd>【二手教材】《软件工程》</dd>
            <dd><span>￥2.00</span></dd>
        </dl>
    </a></div>
    <div class="pList clearfix tran"><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/1.png" /><span class="abr"></span></dt>
            <dd>【疑难解答】C++中纯虚函数的作用是啥？</dd>
            <dd><span>￥5.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/1.png" /><span class="abr"></span></dt>
            <dd>【疑难解答】c++中纯虚函数的作用是啥？</dd>
            <dd><span>￥5.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/1.png" /><span class="abr"></span></dt>
            <dd>【疑难解答】c++中纯虚函数的作用是啥？</dd>
            <dd><span>￥5.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/1.png" /><span class="abr"></span></dt>
            <dd>【疑难解答】c++中纯虚函数的作用是啥？</dd>
            <dd><span>￥2.80</span></dd>
        </dl>
    </a></div>
    <div class="pList clearfix tran"><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s5.png" /><span class="abr"></span></dt>
            <dd>【疑难解答】数据库作业是啥</dd>
            <dd><span>￥5.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s8.png" /><span class="abr"></span></dt>
            <dd>【发布悬赏】赵一石老师的联系方式是什么？</dd>
            <dd><span>￥2.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s1.png" /><span class="abr"></span></dt>
            <dd>【球队招募】喜欢打篮球的小伙伴可以加群</dd>
            <dd><span>￥0.00</span></dd>
        </dl>
    </a><a href="#">
        <dl>
            <dt><span class="abl"></span><img src="img/s2.png" /><span class="abr"></span></dt>
            <dd>【表白墙】表白现代软件工程课的赵一石老师</dd>
            <dd><span>￥0.00</span></dd>
        </dl>
    </a>
    </div>
</div>

<!--footer-->
<div class="footer">
    <p class="dibu">CUG软工小队<br />
    </p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<!-- <script src="js/nav.js" type="text/javascript" charset="utf-8"></script> -->
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});
</script>
</body>

</html>