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
<form action="/goods/add" method="POST">
    商品名：<input type="text" name="shopName" value="${goods.shopName}"><br>
    shop_status：<input type="text" name="shopStatus" value="${goods.shop_status}"><br>
    shop_detil：<input type="text" name="shopDetail" value="${goods.shopDetil}"><br>
    商户ID：<input type="text" name="posId" value="${goods.pos_id}"><br>
    建立时间：<input type="date"  lay-verify="required|nounique" value="${goods.createTime}"   placeholder="建立时间"  name="createTime"  autocomplete="off" class="layui-input"><br>
    更新时间：<input type="date"  lay-verify="required|nounique" value="${goods.updateTime}"   placeholder="更新时间"  name="updateTime"  autocomplete="off" class="layui-input"><br>

    <input type="submit" value="提交">
</form>

</body>
</html>
