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
            <h2>${keyword}号房源评论</h2>
            <div class="gxin">
                <div class="tx">
                    <a href="#">
                        <img src="img/cug1.jpg"/>
                        <p id="avatar"></p>
                    </a>
                </div>
                <div class="xx">
                    <h3 class="clearfix">
                        <strong class="fl">一共${comlist.size()}条评论</strong>
                    </h3>
                    <c:forEach var="com" items="${comlist}">
                        <c:if test="${com.parent_fid==0}">
                            <div>|-${com.commend}</div>
                        </c:if>
                        <c:forEach var="zcom" items="${comlist}">
                            <c:if test="${com.fid==zcom.parent_fid}">
                                <div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zcom.commend}</div>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>
            <div class="container clearfix">
                <div class="main-wrap">
                    <div class="result-wrap">
                        <div class="result-content">
                            <form action="/Wuhan_System/web_docomadd" method="post" id="myform" name="myform">
                                <input type="hidden" name="house_fid" value="${keyword}">
                                <table class="insert-tab" width="100%">
                                    <tbody>
                                    <tr>
                                        <th>你的评论</th>
                                        <td>
                                            <input class="common-text required" id="title" name="commend" size="50"
                                                   value="" type="text">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th></th>
                                        <td>
                                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
