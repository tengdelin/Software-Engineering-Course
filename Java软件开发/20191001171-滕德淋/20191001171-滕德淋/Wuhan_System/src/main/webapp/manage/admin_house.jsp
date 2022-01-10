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
                class="crumb-step">&gt;</span><span class="crumb-name">房源管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="/Wuhan_System/manage/admin_dohouseselect" method="get">
                <table class="search-tab">
                    <tr>

                        <th width="70">关键字:</th>
                        <td><input class="common-text" placeholder="关键字" name="keywords" value="${keyword}" id=""
                                   type="text"></td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>


    <div class="result-wrap">
        <form action="/Wuhan_System/manage/admin_dohousedel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_houseadd.jsp">
                        <i class="icon-font"></i>新增房源
                    </a>
                    <a id="batchDel" href="javascript:delmore('你确定删除这些房源吗？','myform')">
                        <i class="icon-font"> </i>批量删除
                    </a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th class="tc" width="5%">
                            <input class="allChoose" name="" onclick="selall(this)" type="checkbox">
                        </th>
                        <th>房号</th>
                        <th>户型</th>
                        <th>总价格</th>
                        <th>平均价格</th>
                        <th>建筑面积</th>
                        <th>室内面积</th>
                        <th>朝向</th>
                        <th>小区名字</th>
                        <th>楼层</th>
                        <th>总楼层</th>
                        <th>建筑年份</th>
                        <th>房屋类型</th>
                        <th>操作</th>

                    </tr>


                    <c:forEach var="h" items="${houselist}">
                        <tr>
                            <td class="tc"><input name="id[]" value="${h.fid}" type="checkbox"></td>
                            <td> ${h.fid} </td>
                            <td> ${h.huxin} </td>
                            <td> ${h.totalprize} </td>
                            <td> ${h.avgprize} </td>
                            <td> ${h.allarea} </td>
                            <td> ${h.innerarea} </td>
                            <td> ${h.chaoxiang} </td>
                            <td> ${h.name} </td>
                            <td> ${h.floor} </td>
                            <td> ${h.allfloor} </td>
                            <td> ${h.year} </td>
                            <td> ${h.neixin} </td>
                            <td>
                                <a class="link-update"
                                   href="admin_tohouseupdate?id=${h.fid}&cpage=${cpage}">修改</a>
                                <a class="link-del"
                                   href="javascript:Delete('你确定要删除房源【${h.fid}】吗？','/Wuhan_System/manage/admin_dohousedel?id=${h.fid}&cpage=${cpage}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>


                    <script>
                        //删除用户弹出和跳转
                        function Delete(mess, url) {
                            if (confirm(mess)) {
                                location.href = url;
                            }
                        }

                        //复选框，全选
                        function selall(o) {
                            var a = document.getElementsByName('id[]');
                            for (var i = 0; i < a.length; i++) {
                                a[i].checked = o.checked;
                            }
                        }

                        //多选删除
                        function delmore(mess, forname) {
                            if (confirm(mess)) {
                                var form = document.getElementById(forname);
                                form.submit();
                            }
                        }
                    </script>

                </table>


                <div class="list-page">
                    共${tsum}条数据, 当前${cpage}/${tpage}页
                    <a href="admin_dohouseselect?cp=1"${searchParams}>首页</a>
                    <a href="admin_dohouseselect?cp=${cpage-1<=0?1:cpage-1}${searchParams}">上一页</a>
                    <a href="admin_dohouseselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                    <a href="admin_dohouseselect?cp=${tpage}${searchParams}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
