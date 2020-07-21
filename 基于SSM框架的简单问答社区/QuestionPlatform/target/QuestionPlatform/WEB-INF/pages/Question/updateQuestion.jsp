<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/14
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <title>修改问题</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-4 col-md-offset-4">
        <div style="text-align: center;margin-top: 100px;">
            <p style="font-size: 50px;">修改问题</p>
        </div>
        <form action="<%=path%>/Question/UpdateQuestion" role="form" style="margin-top: 50px;">
            <div class="form-group">
                <input id="question_id" name="question_id" type="hidden"
                       class="form-control" value=${question.question_id}></input>   <%-- 上传问题的编号 默认隐藏 --%>
            </div>
            <div class="form-group">
                <label for="question_title">问题标题</label>
                <input id="question_title" name="question_title" maxlength="50"
                       class="form-control" rows="5" placeholder="请您输入不要超过50字" value=${question.question_title}></input>
            </div>
            <div class="form-group">
                <label for="question_content">问题内容</label>
                <textarea id="question_content" name="question_content" class="form-control" rows="20">${question.question_content}</textarea>
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
