<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/26
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
            <h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <b>
                        <a href="#" id="login">${name.USER_IDENITY_CODE}</a>
                        <a href="#" id="login">${name.USER_ID}</a>
                        <a href="#" id="reg">${name.USER_NAME}</a>
                    </b>
                </p>
                <%--                <form action="#" method="get" class="fl">--%>
                <%--                    <input type="text" placeholder="热门搜索：步道乐跑"/>--%>

                <a href="/Web03/manage/admin_login.jsp"><b>后台管理</b></a><br>
                <a href="index.html"><b>退出登录</b></a>
                <%--                    <input type="button"/>--%>
                <%--                </form>--%>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="#">学习天地</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <a href="cet.jsp">
                            <dl>
                                <dt><img src="img/CET.png"/></dt>
                                <dd>四六级书籍</dd>
                            </dl>
                        </a><a href="test.jsp">
                        <dl>
                            <dt><img src="img/考研.png"/></dt>
                            <dd>考研书籍</dd>
                        </dl>
                    </a><a href="schoolbook.jsp">
                        <dl>
                            <dt><img src="img/学校教材.jpg"/></dt>
                            <dd>学校教材</dd>
                        </dl>
                    </a><a href="question.jsp">
                        <dl>
                            <dt><img src="img/题目问答.jpg"/></dt>
                            <dd>题目问答</dd>
                        </dl>
                    </a>
                    </div>
                </div>
            </li>
            <li><a href="#">舞动青春</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <a href="left.jsp">
                            <dl>
                                <dt><img src="img/live1.jpg"/></dt>
                                <dd>失物招领</dd>
                            </dl>
                        </a><a href="get.jsp">
                        <dl>
                            <dt><img src="img/live2.jpg"/></dt>
                            <dd>代取快递</dd>
                        </dl>
                    </a><a href="market.jsp">
                        <dl>
                            <dt><img src="img/live3.jpg"/></dt>
                            <dd>二手市场</dd>
                        </dl>
                    </a><a href="run.jsp">
                        <dl>
                            <dt><img src="img/live4.jpg"/></dt>
                            <dd>外卖跑腿</dd>
                        </dl>
                    </a><a href="offer1.jsp">
                        <dl>
                            <dt><img src="img/live5.jpg"/></dt>
                            <dd>有偿发布</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><a href="#">校外访客</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <a href="show.jsp">
                            <dl>
                                <dt><img src="img/2.png"/></dt>
                                <dd>地大简介</dd>
                            </dl>
                        </a>
                        <a href="https://ditu.amap.com/search?id=B0FFGXTV88&city=420111&geoobj=113.51792%7C30.068916%7C115.758051%7C31.151547&query_type=IDQ&query=%E4%B8%AD%E5%9B%BD%E5%9C%B0%E8%B4%A8%E5%A4%A7%E5%AD%A6%E6%9C%AA%E6%9D%A5%E5%9F%8E%E6%A0%A1%E5%8C%BA&zoom=9.37" target="_blank">
                        <dl>
                            <dt><img src="img/3.png"/></dt>
                            <dd>校园地图</dd>
                        </dl>
                    </a><a href="rounding.jsp">
                        <dl>
                            <dt><img src="img/4.png"/></dt>
                            <dd>景点介绍</dd>
                        </dl>
                    </a><a href="http://www.okaoyan.com/fenshuxian/110746_4.html">
                        <dl>
                            <dt><img src="img/5.png"/></dt>
                            <dd>往年考研真题与录取分数</dd>
                        </dl>
                    </a><a href="life.jsp">
                        <dl>
                            <dt><img src="img/6.png"/></dt>
                            <dd>在校学生体验</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><a href="#">江湖秘籍</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <a href="happy.jsp">
                            <dl>
                                <dt><img src="img/lepao.jpg"/></dt>
                                <dd>乐跑互助</dd>
                            </dl>
                        </a><a href="lesson.jsp">
                        <dl>
                            <dt><img src="img/wangke.jpg"/></dt>
                            <dd>帮刷网课</dd>
                        </dl>
                    </a><a href="work.jsp">
                        <dl>
                            <dt><img src="img/keshe.jpg"/></dt>
                            <dd>悬赏课设</dd>
                        </dl>
                    </a><a href="love.jsp">
                        <dl>
                            <dt><img src="img/biaobai.jpg"/></dt>
                            <dd>表白墙</dd>
                        </dl>
                    </a><a href="share.jsp">
                        <dl>
                            <dt><img src="img/share.jpg"/></dt>
                            <dd>资源分享</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li>
                <a href="https://www.cug.edu.cn/" target="_blank">CUG</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
