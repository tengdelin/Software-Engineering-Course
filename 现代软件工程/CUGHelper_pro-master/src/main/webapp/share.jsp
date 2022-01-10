<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/27
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>江湖秘籍</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@include file="header.jsp"%>
<%--<div class="head">--%>
<%--    <div class="wrapper clearfix">--%>
<%--        <div class="clearfix" id="top">--%>
<%--            <h1 class="fl"><a href="index.html"><img src="img/logo.png" /></a></h1>--%>
<%--            <div class="fr clearfix" id="top1">--%>
<%--                <p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>--%>
<%--                </p>--%>
<%--                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：步道乐跑" /><input--%>
<%--                        type="button" /></form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <ul class="clearfix" id="bott">--%>
<%--            <li><a href="index.html">首页</a></li>--%>
<%--            <li><a href="flowerDer.html">学习天地</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix">--%>
<%--                        <a href="cet.html">--%>
<%--                            <dl>--%>
<%--                                <dt><img src="img/CET.png" /></dt>--%>
<%--                                <dd>四六级书籍</dd>--%>
<%--                            </dl>--%>
<%--                        </a><a href="test.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/考研.png" /></dt>--%>
<%--                            <dd>考研书籍</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="schoolbook.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/学校教材.jpg" /></dt>--%>
<%--                            <dd>学校教材</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="question.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/题目问答.jpg" /></dt>--%>
<%--                            <dd>题目问答</dd>--%>
<%--                        </dl>--%>
<%--                    </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="decoration.html">舞动青春</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="left.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live1.jpg" /></dt>--%>
<%--                            <dd>失物招领</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="get.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live2.jpg" /></dt>--%>
<%--                            <dd>代取快递</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="market.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live3.jpg" /></dt>--%>
<%--                            <dd>二手市场</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="run.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live4.jpg" /></dt>--%>
<%--                            <dd>外卖跑腿</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="offer1.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live5.jpg" /></dt>--%>
<%--                            <dd>有偿发布</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="paint.html">校外访客</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="show.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/2.png" /></dt>--%>
<%--                            <dd>地大简介</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="map.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/3.png" /></dt>--%>
<%--                            <dd>校园地图</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="rounding.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/4.png" /></dt>--%>
<%--                            <dd>景点介绍</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="http://www.okaoyan.com/fenshuxian/110746_4.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/5.png" /></dt>--%>
<%--                            <dd>往年考研真题与录取分数</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="life.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/6.png" /></dt>--%>
<%--                            <dd>在校学生体验</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="perfume.html">江湖秘籍</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="happy.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/lepao.jpg" /></dt>--%>
<%--                            <dd>乐跑互助</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="lesson.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/wangke.jpg" /></dt>--%>
<%--                            <dd>帮刷网课</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="work.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/keshe.jpg" /></dt>--%>
<%--                            <dd>悬赏课设</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="love.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/biaobai.jpg" /></dt>--%>
<%--                            <dd>表白墙</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="share.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/share.jpg" /></dt>--%>
<%--                            <dd>资源分享</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <a href="https://www.cug.edu.cn/" target="_blank">CUG</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</div>--%>
<!-----------------banner------------------------------->
<div class="banner"><a href="#"><img src="img/temp/jianghu.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp">首页</a>
        <span>/</span>
        <a href="#" class="on">江湖秘籍</a>
        <span>/</span>
        <a href="share.jsp" class="on">资源分享</a>
        <span>/</span>
        <a href="offer1.jsp" class="on">
            <font color='red'>我要发布</font>
        </a>
    </div>
</div><!-----------------paintCon------------------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">资源分享</h3>
    </div>
</div>
<div class="paintCon">
    <div class="paintList"><a href=" ">
        <dl>
            <dt><img src="img/temp/0.jpg"></dt>
            <dd>考研资源</dd>
            <!-- <dd>￥299.90</dd> -->
        </dl>
    </a><a href=" ">
        <dl>
            <dt><img src="img/temp/kaoshi.jpg"></dt>
            <dd>考试材料</dd>
            <!-- <dd>￥299.90</dd> -->
        </dl>
    </a><a href=" ">
        <dl>
            <dt><img src="img/temp/shu.jpg"></dt>
            <dd>重要考点</dd>
            <!-- <dd>￥299.90</dd> -->
        </dl>
    </a><a href=" ">
        <dl>
            <dt><img src="img/temp/qita.jpg"></dt>
            <dd>其他资源</dd>
            <!-- <dd>￥299.90</dd> -->
        </dl>

    </a></div>
    <!--footer-->
    <div class="footer">
        <p class="dibu">CUG软工小队<br />
        </p>
    </div>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/public.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
