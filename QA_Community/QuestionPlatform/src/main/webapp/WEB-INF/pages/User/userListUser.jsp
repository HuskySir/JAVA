<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/9
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div style="text-align: center;">
            <c:if test="${method eq 'FindOfToUser'}">
                <h1>${login_user_nickname},您的关注用户数：${count}</h1>
            </c:if>
            <c:if test="${method eq 'FindOfFromUser'}">
                <h1>${login_user_nickname},您的粉丝数：${count}</h1>
            </c:if>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table class="table table-hover table-bordered">
                    <thead class="thead-dark">
                        <tr style="font-size: 15px;">
                            <th style="text-align:center">用户昵称</th>
                            <th style="text-align:center">用户名</th>
                            <th style="text-align:center">粉丝数</th>
                            <th style="text-align:center">提出的问题数</th>
                            <th style="text-align:center">做出的回答数</th>
                        </tr>
                    </thead>
                    <c:forEach items="${users}" var="user" varStatus="loop">
                    <tr style="text-align: center;font-size: 10px;">
                        <td><a href="<%=path%>/User/DisplayUserInfo?user_id=${user.user_id}"><c:out value="${user.user_nickname}"></c:out></a></td>
                        <td><c:out value="${user.user_name}"></c:out></td>
                        <td><c:out value="${userRelations[loop.index].from_user_count}"></c:out></td>
                        <td><c:out value="${userRelations[loop.index].ask_question_count}"></c:out></td>
                        <td><c:out value="${userRelations[loop.index].make_answer_count}"></c:out></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
