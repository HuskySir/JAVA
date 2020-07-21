<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/14
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改个人信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-4 col-md-offset-4">
        <div style="text-align: center;margin-top: 100px;">
            <p style="font-size: 50px;">修改个人信息</p>
        </div>
        <form action="<%=path%>/User/UpdateUser" role="form" style="margin-top: 50px;">
            <div class="form-group">
                <label for="user_name">用户名</label>
                <input id="user_name" name="user_name" maxlength="50" readonly="readonly"
                       class="form-control" required="true" rows="5" value="${user.user_name}"></input>     <%-- 默认不可更改 --%>
            </div>
            <div class="form-group">
                <label for="user_nickname">用户昵称</label>
                <input id="user_nickname" name="user_nickname" maxlength="50"
                       class="form-control" required="true" rows="5" value="${user.user_nickname}"></input>
            </div>
            <div class="form-group">
                <div class="row">
                    <label class="control-label col-md-2">用户性别：</label>
                    <div class="col-md-4">
                        <c:if test="${user.user_sex eq '男'}">
                            <input type="radio" id="user_sex" name="user_sex" value="男" checked="checked">男
                            <input type="radio" id="user_sex" name="user_sex" value="女">女
                        </c:if>
                        <c:if test="${user.user_sex eq '女'}">
                            <input type="radio" id="user_sex" name="user_sex" value="男">男
                            <input type="radio" id="user_sex" name="user_sex" value="女" checked="checked">女
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="user_email">用户邮箱</label>
                <input id="user_email" name="user_email" maxlength="50"
                       class="form-control" required="true" rows="5" value="${user.user_email}"></input>
            </div>
            <div class="form-group">
                <label for="user_password">用户密码</label>
                <input id="user_password" name="user_password" maxlength="50"
                       class="form-control" required="true" rows="5" value="${user.user_password}"></input>
            </div>

            <div class="row">
                <div class="col-md-12" style="text-align: center;">
                    <button type="submit" class="btn btn-success" style="width: 150px;">确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
