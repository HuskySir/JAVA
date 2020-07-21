<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/11
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>提问页面</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<body>

    <div class="container-fluid">
        <div class="col-md-4 col-md-offset-4">
            <div style="text-align: center;margin-top: 100px;">
                <p style="font-size: 50px;">提问页面</p>
            </div>
            <form name="saveQuestion" action="<%=path%>/Question/SaveQuestion" method="post" role="form" style="margin-top: 50px;">
                <div class="form-group">
                    <label for="question_title">问题标题</label>
                    <input id="question_title" name="question_title" maxlength="50"
                           class="form-control" required="true" rows="5" placeholder="请您输入不要超过50字"></input>
                </div>
                <div class="form-group">
                    <label for="question_content">问题内容</label>
                    <textarea id="question_content" name="question_content" class="form-control" required="true" rows="20"></textarea>
                </div>
                <div class="row">
                    <div class="col-md-6" style="text-align: center;">
                        <input type="submit" class="btn btn-success"></button>
                    </div>
                    <div class="col-md-6" style="text-align: center;">
                        <input type="reset" class="btn btn-danger" value="重置内容"></input>
                    </div>
                </div>
            </form>
            <div style="text-align: center;">
                <a href="javascript:history.go(-1)"><button class="btn btn-warning">返回用户页面</button></a>
            </div>
        </div>
    </div>
</body>
</body>
</html>


