%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2019/6/21/021
Time: 11:24
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    /*获取工程路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        //查询事件
        function findData(){
            $('#currentPage').val('1');
            document.forms[0].submit();
        }
        //清空查询条件
        function clearP(){
            $("#name").val("");
            $("#loginName").val("");
        }

        //删除用户
        function del(id) {
            if(confirm("确定要删除该用户吗？")){
                $.ajax({
                    url:"<%=basePath%>user/del",
                    type:"post",
                    dataType:"json",
                    data:{id:id},
                    success:function () {
                        alert("删除成功！");
                        $("#myform").submit();
                    },
                    error:function () {//不知道为什么有时会走error
                        alert("删除成功！");
                        $("#myform").submit();
                    }
                });
            }
        }
        //编辑用户 先获取当前ID用户信息
        function edit(id) {
            $.ajax({
                url:"<%=basePath%>user/selectUserById",
                type:"post",
                dataType:"json",
                data:{id:id},
                success:function (data) {
                    $("#editModal").modal("show");
                    $("#loginName2").val(data.loginName);
                    $("#password2").val(data.password);
                    $("#userName").val(data.userName);
                    $("#myid").val(data.id);
                    $("#imgs").attr("src",data.shopPic.userPic);
                    var status = data.status;
                    console.log(status)
                    if(status=="1"){
                        $("#rstatus1").prop('checked',true);
                    }else{
                        $("#rstatus2").prop('checked',true);
                    }
                },
                error:function () {
                    alert("获取用户数据失败！");
                }
            });
        }
    </script>
</head>
<body>
<div class="table-responsive">
    <form class="form-inline" role="form" action="<%=basePath%>user/selectAll" method="post" id="myform">
        <div style="margin-left: 80px;">
            姓名：<input type="text" name="userName" id="name" value="${userInfo1.userName}" class="form-control" style="width: 120px;">
            账号：<input type="text" name="loginName" id="loginName" value="${userInfo1.loginName}" class="form-control" style="width: 120px;">
            <input type="button" onclick="findData();" class="btn btn-info" value="查询"/>
            <input type="button" onclick="clearP();" class="btn btn-info" value="清空"/>
            <input type="button" data-toggle="modal" data-target="#addModal" class="btn btn-info" value="新增"/>
        </div>
        <hr style="margin-top: 10px;"/>
        <div style="margin-left: 20px;">
            <table class="table table-hover">
                <thead>
                <tr style="text-align: center">
                    <th style="text-align: center">序号</th>
                    <th style="text-align: center">头像</th>
                    <th style="text-align: center">姓名</th>
                    <th style="text-align: center">登录名</th>
                    <th style="text-align: center">当前状态</th>
                    <th style="text-align: center">创建时间</th>
                    <th style="text-align: center">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${!empty userList }">
                    <c:forEach items="${userList}" var="user">
                        <tr style="text-align: center">
                            <td>${user.id}</td>
                            <td>
                                <c:if test="${user.shopPic.status=='0'}">
                                    <img width=" 50px" height="50px" src="${user.shopPic.path}">
                                </c:if>
                                <c:if test="${user.shopPic.status=='1'}">
                                    <img width=" 50px" height="50px" src="http://pr2oanyfn.bkt.clouddn.com/u=3648303822,342754098&fm=26&gp=0">
                                </c:if>

                            </td>
                            <td>${user.userName }</td>
                            <td>${user.loginName }</td>
                            <td>
                                <c:if test="${user.status ==1}">正常</c:if>
                                <c:if test="${user.status ==0}">失效</c:if>
                            </td>
                            <td><fmt:formatDate value="${user.createTime}" pattern='yyyy-MM-dd ' /></td>
                            <td>
                                <button type="button" class="btn btn-success" onclick="edit('${user.id }')">编辑</button>
                                <button type="button" class="btn btn-danger" onclick="del('${user.id }')">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <div >
                <jsp:include page="../../../common/page.jsp"/>
            </div>
        </div>
    </form>
</div>
<!-- 新增用户模态框（Modal） -->
<form action="<%=basePath%>user/addUser" enctype="multipart/form-data" method="post" id="register_form1">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 id="mytitle" class="modal-title" id="myModalLabel">
                        新增用户
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" id="name1" placeholder="用户名" name="userName" autofocus="autofocus"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="登录名" id="age1" name="loginName" autofocus="autofocus"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password1" name="password"/>
                    </div>
                    <div class="form-group">
                        <label for="inputfile">头像上传</label>
                        <input type="file" name="file" id="inputfile">
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" id="status1" value="1" checked>
                            正常
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" id="status2" value="0">
                            失效
                        </label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" id="insertUser" class="btn btn-info">
                        确认
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<!-- 编辑用户模态框（Modal） -->
<form action="<%=basePath%>user/addUser" enctype="multipart/form-data" method="post" id="editModalForm">
    <input type="hidden" id="myid" name="myid"/>
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 id="mytitle1" class="modal-title" id="myModalLabel1">
                        编辑用户
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        用户名： <input class="form-control required" type="text" placeholder="用户名" id="userName" name="userName" autofocus="autofocus"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        登录名: <input class="form-control required" type="text" placeholder="登录名" id="loginName2" name="loginName" autofocus="autofocus"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        密码： <input class="form-control required" type="password" placeholder="密码" id="password2" name="password"/>
                    </div>
                    头像：<img id="imgs" width="50px" height="50px">
                    <div class="form-group">
                        <label for="inputfile">头像上传</label>
                        <input type="file" name="file" id="inputfiles">
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" id="rstatus1" value="1"/>
                            正常
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" id="rstatus2" value="0">
                            失效
                        </label>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="submit" class="btn btn-info">
                    确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
    </div>
</form>
</body>
</html>


