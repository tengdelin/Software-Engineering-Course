<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/13
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
                class="crumb-step">&gt;</span><span class="crumb-name">评论回复</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="/Wuhan_System/manage/admin_docomselect" method="get">
                <table class="search-tab">
                    <tr>

                        <th width="70">房源号:</th>
                        <td><input class="common-text" placeholder="房源号" name="keywords" value="${keyword}" id=""
                                   type="text"></td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>


    <div class="result-wrap">
        <form action="" id="myform" method="post">
            <div class="result-content">
                <table class="result-tab" width="70%">
                    <tr>

                        <th>房源号</th>
                        <th>评论内容</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach var="com" items="${comlist}">
                        <tr>
                            <c:if test="${com.parent_fid==0}">

                                <td>${com.house_fid}(用户评论)</td>
                                <td>|-${com.commend}</td>
                                <td>
                                    <a class="link-update"
                                       href="admin_tocomadd?id=${com.fid}&cpage=${cpage}">回复</a>
                                    <a class="link-del"
                                       href="javascript:Delete('你确定要删除评论该吗？','/Wuhan_System/manage/admin_docomdel?id=${com.fid}&cpage=${cpage}')">删除</a>
                                </td>
                            </c:if>
                        </tr>
                        <c:forEach var="zcom" items="${comlist}">
                            <c:if test="${com.fid==zcom.parent_fid}">
                                <tr>
                                    <td>${zcom.house_fid}(回复内容)</td>
                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zcom.commend}</td>
                                    <td>
                                        <a class="link-update"
                                           href="admin_tocomupdate?id=${zcom.fid}&cpage=${cpage}">修改</a>
                                        <a class="link-del"
                                           href="javascript:Delete('你确定要删除该评论吗？','/Wuhan_System/manage/admin_docomdel?id=${zcom.fid}&cpage=${cpage}')">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:forEach>

                    <script>
                        //删除用户弹出和跳转
                        function Delete(mess, url) {
                            if (confirm(mess)) {
                                location.href = url;
                            }
                        }

                    </script>

                </table>


                <div class="list-page">
                    共${tsum}条数据, 当前${cpage}/${tpage}页
                    <a href="admin_docomselect?cp=1"${searchParams}>首页</a>
                    <a href="admin_docomselect?cp=${cpage-1<=0?1:cpage-1}${searchParams}">上一页</a>
                    <a href="admin_docomselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                    <a href="admin_docomselect?cp=${tpage}${searchParams}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
