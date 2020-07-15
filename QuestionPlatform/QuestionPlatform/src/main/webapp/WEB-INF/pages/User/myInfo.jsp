<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/15
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div style="text-align: center;margin-top: 300px;">
        <div class="row">
            <div class="col-md-6 col-md-offset-5" style="text-align: left;">
                <h2>用户名:${user.user_name}</h2>
                <h2>用户昵称:${user.user_nickname}</h2>
                <h2>用户性别:${user.user_sex}</h2>
                <h2>用户邮箱:${user.user_email}</h2>
                <h2>用户密码:${user.user_password}</h2>
            </div>
        </div>
        <div class="row" style="margin-top: 20px;">
            <div class="col-md-2 col-md-offset-3" style="text-align: right;">
                <a href="<%=path%>/User/DisplayUpdateUser">
                    <button type="submit" class="btn btn-warning" style="width: 150px;">修改用户信息</button>
                </a>
            </div>
            <div class="col-md-2" style="text-align: center;">
                <a href="javascript:history.go(0)"><button class="btn btn-info" style="width: 150px;">刷新个人信息</button></a>
            </div>
            <div class="col-md-2" style="text-align: left;">
                <a href="<%=path%>/User/VerifyDeleteUser">
                    <button class="btn btn-danger" style="width: 150px;">注销账号</button>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
