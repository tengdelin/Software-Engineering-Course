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
                class="crumb-step">&gt;</span><span class="crumb-name">房源查询</span></div>
    </div>
    <div class="search-wrap">
        <div class="result-content">
            <form action="/Wuhan_System/manage/admin_readhouse" method="post" id="myform" name="myform">
                <table class="insert-tab" width="50%">
                    <tbody>
                    <tr>
                        <td>
                            行政区选择：
                            <select class="common-text required" name="wh_xz_name">
                                <option value="-1" selected="selected">--请选择--</option>
                                <c:forEach var="wh_xz" items="${wh_xzlist}">
                                    <option value="${wh_xz.locname}">
                                            ${wh_xz.locname}
                                    </option>
                                </c:forEach>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="btn btn-primary btn6 mr10" value="筛选" type="submit">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <form action="/Wuhan_System/manage/admin_readhouse" method="post" id="myform" name="myform">
                <table class="insert-tab" width="50%">
                    <tbody>
                    <tr>
                        <td>
                            小区选择：
                            <select class="common-text required" name="home_name">
                                <option value="-1" selected="selected">--请选择--</option>
                                <c:forEach var="home" items="${homelist}">
                                    <option value="${home.name}">
                                            ${home.name}
                                    </option>
                                </c:forEach>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;

                            <input class="btn btn-primary btn6 mr10" value="筛选" type="submit">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <form action="/Wuhan_System/manage/admin_readhouse" method="post" id="myform" name="myform">
                <table class="insert-tab" width="50%">
                    <tbody>
                    <tr>
                        <td>
                            售价：
                            <select class="common-text required" name="totalprize">
                                <option value="-1" selected="selected">--请选择--</option>
                                <option value="0" >50万以下</option>
                                <option value="50">50-100万</option>
                                <option value="100">100-150万</option>
                                <option value="150" >150-200万</option>
                                <option value="200">200万以上</option>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="btn btn-primary btn6 mr10" value="筛选" type="submit">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <form action="/Wuhan_System/manage/admin_readhouse" method="post" id="myform" name="myform">
                <table class="insert-tab" width="50%">
                    <tbody>
                    <tr>
                        <td>
                            房型：
                            <select class="common-text required" name="huxin">
                                <option value="-1" selected="selected">--请选择--</option>
                                <c:forEach var="huxin" items="${huxinlist}">
                                    <option value="${huxin.huxin}">
                                            ${huxin.huxin}
                                    </option>
                                </c:forEach>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="btn btn-primary btn6 mr10" value="筛选" type="submit">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <form action="/Wuhan_System/manage/admin_readhouse" method="post" id="myform" name="myform">
                <table class="insert-tab" width="50%">
                    <tbody>
                    <tr>
                        <td>
                            面积：
                            <select class="common-text required" name="area">
                                <option value="-1" selected="selected">--请选择--</option>
                                <option value="0" >50平米以下</option>
                                <option value="50" >50-100平米</option>
                                <option value="100" >100-150平米</option>
                                <option value="150" >150平米以上</option>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="btn btn-primary btn6 mr10" value="筛选" type="submit">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <%--            <form action="/Wuhan_System/manage/admin_douserselect" method="get">--%>
            <%--            <table class="search-tab">--%>
            <%--                <tr>--%>
            <%--                    <th width="70">关键字:</th>--%>
            <%--                    <td><input class="common-text" placeholder="关键字" name="keywords" value="${keyword}" id=""--%>
            <%--                               type="text"></td>--%>
            <%--                    <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>--%>
            <%--                </tr>--%>
            <%--            </table>--%>
            <%--        </form>--%>

        </div>

    </div>


    <div class="result-wrap">
        <form action="" id="myform" method="post">
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <p>一共${num}条数据</p>
                    <tr>
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
                    </tr>
                    <c:forEach var="h" items="${houselist}">
                        <tr>
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
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${flag==true}">
                    <div class="list-page">
                        共${tsum}条数据, 当前${cpage}/${tpage}页
                        <a href="admin_readhouse?cp=1"${searchParams}>首页</a>
                        <a href="admin_readhouse?cp=${cpage-1<=0?1:cpage-1}${searchParams}">上一页</a>
                        <a href="admin_readhouse?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                        <a href="admin_readhouse?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </c:if>

            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
