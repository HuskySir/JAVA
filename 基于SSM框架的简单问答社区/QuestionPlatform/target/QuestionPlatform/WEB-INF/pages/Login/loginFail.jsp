<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/9
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录失败</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="col-md-4 col-md-offset-4">
            <div style="text-align: center;margin-top: 300px">
                <p style="margin-top: 50px;font-size: 50px;">登录失败,请重新登录</p>
                <p style="margin-top: 20px;font-size: 40px;">失败原因：${msg}</p>
                <a href="javascript:history.go(-1)">
                    <button style="font-size: 20px" class="btn btn-warning">返回</button>
                </a>
            </div>
        </div>
    </div>
</body>
</html>
