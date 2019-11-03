<%--
  Created by IntelliJ IDEA.
  User: 54110
  Date: 2019-05-29
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    /*获取工程路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/ztree/js/jquery.ztree.core.js"></script>
<head>
    <title>Title</title>
</head>
<script>
    var setting = {};
    var zNodes =[${shopNode}];
    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
</script>
<body>
<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>
</body>
</html>
