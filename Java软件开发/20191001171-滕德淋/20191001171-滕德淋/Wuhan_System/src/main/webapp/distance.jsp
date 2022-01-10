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
    <title>${keyword}号评论</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/my.css"/>

</head>

<body>

</div>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3>
                <a href="index.jsp"><img src="img/cug1.jpg"/></a>
            </h3>
        </div>
        <div class="you fl">
            <h2>${keyword}号小区周边信息</h2>
            <div class="info5">
                <p align="center">
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light1').style.display='block';document.getElementById('light2').style.display='none';document.getElementById('light3').style.display='none';document.getElementById('light4').style.display='none';document.getElementById('light5').style.display='none';">
                        公园
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light2').style.display='block';document.getElementById('light1').style.display='none';document.getElementById('light3').style.display='none';document.getElementById('light4').style.display='none';document.getElementById('light5').style.display='none';">
                        购物中心
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light3').style.display='block';document.getElementById('light1').style.display='none';document.getElementById('light2').style.display='none';document.getElementById('light4').style.display='none';document.getElementById('light5').style.display='none';">
                        学校
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light4').style.display='block';document.getElementById('light1').style.display='none';document.getElementById('light2').style.display='none';document.getElementById('light3').style.display='none';document.getElementById('light5').style.display='none';">
                        医院
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light5').style.display='block';document.getElementById('light1').style.display='none';document.getElementById('light2').style.display='none';document.getElementById('light4').style.display='none';document.getElementById('light3').style.display='none';">
                        交通
                    </a>
                </p>
                <div id="light1" class="white_content" align="center">
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light1').style.display='none';">关闭</a>
                    <table align="center" border="1" cellspacing="0" width="215" cellpadding="1">
                        <tr>
                           <b><th>公园名字</th></b>
                        </tr>
                        <c:forEach var="p" items="${home_by_park_list}">
                            <tr>
                                <th><a href="#" class="login">${p.park_name}</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                </div>
                <div id="light2" class="white_content" align="center">
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light2').style.display='none';">关闭</a>
                    <table align="center" border="1" cellspacing="0" width="215" cellpadding="1">
                        <tr>
                            <b><th>购物中心名字</th></b>
                        </tr>
                        <c:forEach var="p" items="${home_by_shop_list}">
                            <tr>
                                <th><a href="#" class="login">${p.shop_name}</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                </div>
                <div id="light3" class="white_content" align="center">
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light3').style.display='none';">关闭</a>
                    <table align="center" border="1" cellspacing="0" width="215" cellpadding="1">
                        <tr>
                            <b><th>学校名字</th></b>
                        </tr>
                        <c:forEach var="p" items="${home_by_school_list}">
                            <tr>
                                <th><a href="#" class="login">${p.school_name}</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                </div>
                <div id="light4" class="white_content" align="center">
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light4').style.display='none';">关闭</a>
                    <table align="center" border="1" cellspacing="0" width="215" cellpadding="1">
                        <tr>
                            <b><th>医院名字</th></b>
                        </tr>
                        <c:forEach var="p" items="${home_by_hospital_list}">
                            <tr>
                                <th><a href="#" class="login">${p.hospital_name}</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                </div>
                <div id="light5" class="white_content" align="center">
                    <a href="javascript:void(0)" class="login"
                       onclick="document.getElementById('light5').style.display='none';">关闭</a>
                    <table align="center" border="1" cellspacing="0" width="215" cellpadding="1">
                        <tr>
                            <b><th>交通名字</th></b>
                        </tr>
                        <c:forEach var="p" items="${home_by_transportandroad_list}">
                            <tr>
                                <th><a href="#" class="login">${p.transportandroad_name}</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                </div>
            </div>
        </div>
    </div>

    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</div>
</body>
</html>
