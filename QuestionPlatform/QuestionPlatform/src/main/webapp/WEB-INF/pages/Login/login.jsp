<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/9
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="col-md-4 col-md-offset-4">
            <div style="text-align: center;margin-top: 300px;">
                <h1>用户登录</h1>
            </div>
            <form action="<%=path%>/Login/User" name="loginform" method="post">
                <div class="form-group">
                    <label for="user_name" stype="display:inline;">用户名：</label>
                    <input type="text" class="form-control" id="user_name" name="user_name"
                           onkeyup="this.value=this.value.replace(/[^\w_]/g,'');" style="display:inline;"autocomplete="off" />
                </div>
                <div class="form-group">
                    <label for="user_password" style="display:inline;">用户密码：</label>
                    <input type="password" class="form-control" id="user_password" name="user_password" style="display:inline;"autocomplete="off" />
                </div>
                <div class="col">
                    <div class="col-md-4" style="text-align: right;">
                        <button type="submit" class="btn btn-success">登录</button>
                    </div>
                    <div class="col-md-4 col-md-offset-4" style="text-align: left;">
                        <a href="<%=path%>/Register/RegisterPage">
                            <button type="button" class="btn btn-info">注册</button>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>