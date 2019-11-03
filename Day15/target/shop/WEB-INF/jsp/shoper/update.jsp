<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/20/020
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/shop/update" method="post">
    id:<input type="text" name="id" value="${shoper1.id}">
    商户名：<input type="text" name="posName" value="${shoper1.posName}"><br>
    status：<input type="text" name="posStatus" value="${shoper1.posStatus}"><br>
    时间：<input type="date"  lay-verify="required|nounique" value="${shoper1.posTime}"   placeholder="时间"  name="posTime"  autocomplete="off" class="layui-input"><br>

    <input type="submit" value="提交">
</form>

</body>
</html>
