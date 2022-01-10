<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/13
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/Wuhan_System/manage/admin_index.jsp">首页</a><span
                class="crumb-step">&gt;</span><a class="crumb-name"
                                                 href="/Wuhan_System/manage/admin_docomselect">评论回复</a><span
                class="crumb-step">&gt;</span><span>修改评论</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="/Wuhan_System/manage/admin_docomupdate" method="post" id="myform" name="myform">
                <input type="hidden" name="fid" value="${c.fid}">
                <input type="hidden" name="cpage" value="${cpage}">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>评论编号</th>
                        <td>
                            <input class="common-text required" id="title" readonly="readonly" name="com_fid" size="20" value="${c.fid}"
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>评论内容</th>
                        <td>
                            <input class="common-text required" id="title" name="commend" size="50" value="${c.commend}"
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>对应评论</th>
                        <td>
                            <input class="common-text required" id="title" name="parent_fid" size="20" value="${c.parent_fid}"
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>评论房源</th>
                        <td>
                            <input class="common-text required" id="title" name="house_fid"  size="20" value="${c.house_fid}"
                                   type="text">
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
<!--/main-->
</div>
</body>
</html>
