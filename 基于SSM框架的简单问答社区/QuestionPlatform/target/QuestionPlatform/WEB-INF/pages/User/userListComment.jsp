<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/9
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>评论信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div style="text-align: center;">
        <h1>${login_user_nickname},您做出的评论数:${count}</h1>

    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-hover table-bordered table-condensed">
                <tr style="font-size: 15px;">
                    <th style="text-align:center">评论内容</th>
                    <th style="text-align:center">评论时间</th>
                    <%-- 分级评论功能存在缺陷，目前只提供一级评论功能 --%>
                    <%--<th style="text-align:center">是否是一级评论</th>--%>
                    <th style="text-align:center">评论所在的回答内容</th>
                    <th style="text-align:center">评论所在回答的回答者</th>
                    <th style="text-align:center">评论所在的问题标题</th>
                    <th style="text-align:center">评论所在问题的提问者</th>
                </tr>
                <c:forEach items="${comments}" var="comment" varStatus="loop">
                    <tr style="text-align: center;font-size: 10px;">
                        <td>
                            <a href="<%=path%>/Comment/DisplayCommentInfo?comment_id=${comment.comment_id}">
                                <c:out value="${comment.comment_content}"></c:out>
                            </a>
                        </td>
                        <td>
                            <fmt:formatDate value="${comment.comment_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <%-- 分级评论功能存在缺陷 --%>
                        <%--<td><c:out value="${comment_flags[loop.index].toString()}"></c:out></td>--%>
                        <td><c:out value="${answers[loop.index].answer_content}"></c:out></td>
                        <td><c:out value="${answer_users[loop.index].user_nickname}"></c:out></td>
                        <td><c:out value="${questions[loop.index].question_title}"></c:out></td>
                        <td><c:out value="${question_users[loop.index].user_nickname}"></c:out></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>