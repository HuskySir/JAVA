<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/11
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册成功</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div style="text-align: center;margin-top: 300px;">
            <div>
                <h1>恭喜您，注册成功！</h1>
            </div>
            <div>
                <a href="<%=path%>/Login/LoginPage"><button style="margin-top: 20px;" class="btn btn-success">返回登录页面</button></a>
            </div>
        </div>
    </div>
</body>
</html>
