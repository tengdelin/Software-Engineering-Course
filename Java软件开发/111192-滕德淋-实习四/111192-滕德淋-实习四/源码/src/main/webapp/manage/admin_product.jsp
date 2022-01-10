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
                class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
    </div>
    <div class="result-wrap">
        <form action="/Web03/manage/admin_douserdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="/Web03/manage/admin_toproductadd"><i class="icon-font"></i>新增悬赏</a>
                </div>
            </div>
<%--            <div class="result-content">--%>
<%--                <table class="result-tab" width="80%">--%>
<%--                    <tr>--%>
<%--                        <th>ID</th>--%>
<%--                        <th>分类名称</th>--%>
<%--                        <th>操作</th>--%>
<%--                    </tr>--%>
<%--                    <c:forEach var="cate" items="${catelist}">--%>
<%--                        <tr>--%>
<%--                            <c:if test="${cate.CATE_PARENT_ID==0}">--%>
<%--                                <td>${cate.CATE_ID}</td>--%>
<%--                                <td>|-${cate.CATE_NAME}</td>--%>
<%--                                <td><a href="">删除</a> <a href="">修改</a></td>--%>
<%--                            </c:if>--%>
<%--                        </tr>--%>
<%--                        <c:forEach var="zcate" items="${catelist}">--%>
<%--                            <c:if test="${cate.CATE_ID==zcate.CATE_PARENT_ID}">--%>
<%--                                <tr>--%>
<%--                                    <td>${zcate.CATE_ID}</td>--%>
<%--                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zcate.CATE_NAME}</td>--%>
<%--                                    <td><a href="">删除</a> <a href="">修改</a></td>--%>
<%--                                </tr>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                    </c:forEach>--%>
<%--                </table>--%>

<%--                &lt;%&ndash;                <div class="list-page">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    共${tsum}条数据, 当前${cpage}/${tpage}页&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="admin_douserselect?cp=1"${searchParams}>首页</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="admin_douserselect?cp=${cpage-1<=0?1:cpage-1}${searchParams}">上一页</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <a href="admin_douserselect?cp=${tpage}${searchParams}">尾页</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--            </div>--%>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
