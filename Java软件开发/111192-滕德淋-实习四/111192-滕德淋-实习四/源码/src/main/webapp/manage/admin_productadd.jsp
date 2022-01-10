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
    <div class="crumb-list">
      <i class="icon-font"></i>
      <a href="admin_index.jsp">首页</a>
      <span class="crumb-step">&gt;</span>
      <a class="crumb-name" href="/Web03/manage/admin_productselect">悬赏管理</a>
      <span class="crumb-step">&gt;</span><span>新增悬赏</span>
    </div>
  </div>
  <div class="result-wrap">
    <div class="result-content">
      <form action="/Web03/manage/admin_doproductadd1" method="post" enctype="multipart/form-data">
        <table class="insert-tab" width="100%">
          <tbody>
          <tr>
            <th><i class="require-red">*</i>悬赏名称</th>
            <td>
              <input class="common-text required" id="title" name="productName" size="50" value="" type="text">
            </td>
          </tr>
          <tr>
            <th><i class="require-red">*</i>悬赏分类</th>
            <td>
              <select class="common-text required" name="parentId">
                <c:forEach var="f" items="${flist}">
                  <option value="${f.CATE_ID}" disabled="disabled">|-${f.CATE_NAME}</option>
                  <c:forEach var="c" items="${clist}">
                    <c:if test="${c.CATE_PARENT_ID==f.CATE_ID}">
                      <option value="${f.CATE_ID}-${c.CATE_ID}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          ${c.CATE_NAME}
                      </option>
                    </c:if>
                  </c:forEach>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <th><i class="require-red">*</i>悬赏价格</th>
            <td>
              <input class="common-text required" id="title" name="productprice" size="50" value="" type="text">
            </td>
          </tr>
          <tr>
            <th><i class="require-red">*</i>悬赏内容</th>
            <td>
              <input class="common-text required" id="title" name="productDesc" size="50" value="" type="text">
            </td>
          </tr>
          <tr>
            <th><i class="require-red">*</i>悬赏图片</th>
            <td>
              <input class="common-text required" name="photo" size="50" value=" " type="file">
            </td>
          </tr>
          <tr>
            <th><i class="require-red">*</i>悬赏库存</th>
            <td>
              <input class="common-text required" id="title" name="productstock" size="50" value="" type="text">
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
