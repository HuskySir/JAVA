<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/12
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>

<%--
        **************************************
        ***  子评论功能还有缺陷，故先放弃该功能   ***
        **************************************
--%>

<%--<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>问题详细信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row" style="text-align: center;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h1 class="panel-title">父评论</h1>
            </div>
            <div class="row panel-body" style="text-align: left;margin-left: 10px;">
                <div>
                    <h6>${this_comment.comment_content}</h6>
                </div>
            </div>
            <div class="row" style="text-align: right;margin-top: 10px;">
                <div class="col-md-6">
                    <div class="col-md-4" style="text-align: center;">
                        <h5>评论者：${this_user.user_nickname}</h5>
                    </div>
                    <div class="col-md-4" style="text-align: center;">
                        <h5>评论时间:${this_comment.comment_time}</h5>
                    </div>
                </div>
            </div>
        </div>

        <c:forEach items="${comments}" var="comment" varStatus="loop">
            <div class="panel panel-info">
                <div class="row" style="text-align: left;margin-left: 20px;">
                    <div class="panel-heading" style="text-align: left;margin-left: 10px">
                        <h1 class="panel-title">子评论:${loop.count}楼</h1>
                    </div>
                    <div class="row panel-body" style="text-align: left;margin-left: 10px;">
                        <div>
                            <h6>${comment.comment_content}</h6>
                        </div>
                    </div>
                </div>
                <div class="row" style="text-align: right;margin-top: 10px;">
                    <div class="col-md-6 col-md-offset-6">
                        <div class="col-md-6" style="text-align: center;">
                            <h5>评论者：${next_users[loop.index].user_nickname}</h5>
                        </div>
                        <div class="col-md-6" style="text-align: center;">
                            <h5>评论时间：${comment.comment_time}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>
</div>
</body>
</html>--%>
