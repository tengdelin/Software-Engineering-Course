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
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/Wuhan_System/manage/admin_dohouseselect">房源管理</a>
            <span class="crumb-step">&gt;</span><span>新增房源</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="/Wuhan_System/manage/admin_dohouseadd" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>户型</th>
                        <td>
                            <input class="common-text required" id="title" name="huxin" size="50" value=""
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>总价格</th>
                        <td>
                            <input class="common-text required" id="title" name="totalprize" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>平均价格</th>
                        <td>
                            <input class="common-text required" id="title" name="avgprize" size="50" value=""
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>建筑面积</th>
                        <td>
                            <input class="common-text required" id="title" name="allarea" size="50" value=""
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>室内面积</th>
                        <td>
                            <input class="common-text required" id="title" name="innerarea" size="50" value=""
                                   type="text">
                        </td>
                    </tr>

                    <tr>
                        <th><i class="require-red">*</i>朝向</th>
                        <td>
                            <input class="common-text required" id="title" name="chaoxiang" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>小区名字</th>
                        <td>
                            <input class="common-text required" id="title" name="name" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>楼层</th>
                        <td>
                            <input class="common-text required" id="title" name="floor" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>总楼层</th>
                        <td>
                            <input class="common-text required" id="title" name="allfloor" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>建筑年份</th>
                        <td>
                            <input class="common-text required" id="title" name="year" size="50" value=""
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>房屋类型</th>
                        <td>
                            <input class="common-text required" id="title" name="neixin" size="50" value=""
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
