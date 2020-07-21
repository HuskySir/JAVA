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
    <title>回答信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div style="text-align: center;">
        <c:if test="${method eq 'FindOfToAnswer'}">
            <h1>${login_user_nickname},您赞同的回答数：${count}</h1>
        </c:if>
        <c:if test="${method eq 'FindOfMakeAnswer'}">
            <h1>${login_user_nickname},您做出的回答数：${count}</h1>
        </c:if>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-hover table-bordered table-condensed">
                <tr style="font-size: 15px;">
                    <th style="text-align:center">回答内容</th>
                    <c:if test="${method eq 'FindOfToAnswer'}">
                        <th style="text-align:center">回答者</th>
                    </c:if>
                    <th style="text-align:center">回答赞同量</th>
                    <th style="text-align:center">回答修改时间</th>
                    <th style="text-align:center">回答创建时间</th>
                    <th style="text-align:center">回答所在的问题标题</th>
                    <th style="text-align:center">提问者</th>
                </tr>
                <c:forEach items="${answers}" var="answer" varStatus="loop">
                    <tr style="text-align: center;font-size: 10px;">
                        <td>
                            <a href="<%=path%>/Answer/DisplayAnswerInfo?answer_id=${answer.answer_id}">
                                <c:out value="${answer.answer_content}"></c:out>
                            </a>
                        </td>
                        <c:if test="${method eq 'FindOfToAnswer'}">
                            <td><c:out value="${answer_users[loop.index].user_nickname}"></c:out></td>
                        </c:if>
                        <td><c:out value="${answer.answer_agree_count}"></c:out></td>
                        <td>
                            <fmt:formatDate value="${answer.answer_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${answer.answer_create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
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