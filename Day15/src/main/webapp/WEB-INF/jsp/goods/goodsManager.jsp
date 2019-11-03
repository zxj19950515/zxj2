<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    /*获取工程路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--
  Created by IntelliJ IDEA.
  User: 54110
  Date: 2019-06-20
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table class="table table-bordered" >
        <thead>
        <a href="/goods/testAdd" >增加</a>
        <form class="form-inline" role="form" action="<%=basePath%>goods/goodsAll" method="post" id="myform">
            <tr>
                <th><input type="checkbox" id="checkAll" disabled autocomplete="off"/></th>
                <th>商品名</th>
                <th>shop_status</th>
                <th>shop_detil</th>
                <th>商户ID</th>
                <th>建立时间</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td><input value="" check='box' type="checkbox" /></td>
                <td>${goods.shopName}</td>
                <td>${goods.shopStatus}</td>
                <td>${goods.shopDetil}</td>
                <td>${goods.posId}</td>
                <td>${goods.createTime}</td>
                <td>${goods.updateTime}</td>
                <td>
                    <a href="/goods/selectById/${goods.id}" >修改</a>
                    <a href="/goods/deleteById/${goods.id}" >删除</a>
                </td>
            </tr>
        </c:forEach>
        <div >
            <jsp:include page="../../../common/page.jsp"/>
        </div>
        </form>
    </table>
</div>
</body>
</html>

