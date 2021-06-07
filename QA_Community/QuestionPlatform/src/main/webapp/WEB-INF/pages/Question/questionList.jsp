<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/12
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <title>问题信息</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div style="text-align: center;">
        <c:if test="${method eq 'DisplayAllQuestionList'}">
            <h1>${login_user_nickname},您好！  总问题数：${count}</h1>
        </c:if>
        <c:if test="${method eq 'DisplayQuestionListByCondition'}">
            <h1>${login_user_nickname},您好！  您查询得到的问题数:${count}</h1>
        </c:if>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-hover table-bordered table-condensed">
                <tr style="font-size: 15px;">
                    <th style="text-align:center">问题标题</th>
                    <th style="text-align:center">提问者</th>
                    <th style="text-align:center">关注该问题的用户数</th>
                    <th style="text-align:center">问题的回答数</th>
                    <th style="text-align:center">问题修改时间</th>
                    <th style="text-align:center">问题创建时间</th>
                </tr>
                <c:forEach items="${questions}" var="question" varStatus="loop">
                    <tr style="text-align: center;font-size: 10px;">
                        <td>
                            <a href="<%=path%>/Question/DisplayQuestionAndAnswer?question_id=${question.question_id}">
                                <c:out value="${question.question_title}"></c:out>
                            </a>
                        </td>
                        <td><c:out value="${users[loop.index].user_nickname}"></c:out></td>
                        <td><c:out value="${question.question_follow_count}"></c:out></td>
                        <td><c:out value="${question.question_answer_count}"></c:out></td>
                        <td><fmt:formatDate value="${question.question_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${question.question_create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
