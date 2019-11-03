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
        <a href="/shop/testAdd" >增加</a>
        <form class="form-inline" role="form" action="<%=basePath%>shop/selectAll" method="post" id="myform">
            <tr>
                <th><input type="checkbox" id="checkAll" disabled autocomplete="off"/></th>
                <th>商户名</th>
                <th>status</th>
                <th>时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <c:forEach items="${shoperList}" var="shoper">
            <tr>
                <td><input value="" check='box' type="checkbox" /></td>
                <td>${shoper.posName}</td>
                <td>${shoper.posStatus}</td>
                <td>${shoper.posTime}</td>
                <td>
                    <a href="/shop/selectById/${shoper.id}" >修改</a>
                    <a href="/shop/deleteById/${shoper.id}" >删除</a>
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
