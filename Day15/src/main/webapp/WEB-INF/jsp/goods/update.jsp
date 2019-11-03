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
    id:<input type="text" name="id" value="${goods1.id}"><br>
    商品名：<input type="text" name="shopName" value="${goods1.shopName}"><br>
    shop_status：<input type="text" name="shopStatus" value="${goods1.shopStatus}"><br>
    shop_detil：<input type="text" name="shopDetil" value="${goods1.shopDetil}"><br>
    商户ID：<input type="text" name="posId" value="${goods1.posId}"><br>
    建立时间：<input type="date"  lay-verify="required|nounique" value="${goods1.createTime}"   placeholder="建立时间"  name="createTime"  autocomplete="off" class="layui-input"><br>
    更新时间：<input type="date"  lay-verify="required|nounique" value="${goods1.updateTime}"   placeholder="更新时间"  name="updateTime"  autocomplete="off" class="layui-input"><br>

    <input type="submit" value="提交">
</form>

</body>
</html>