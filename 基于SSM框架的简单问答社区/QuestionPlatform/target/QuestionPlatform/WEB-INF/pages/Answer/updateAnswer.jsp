<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/14
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <title>修改回答</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-4 col-md-offset-4">
        <div style="text-align: center;margin-top: 100px;">
            <p style="font-size: 50px;">修改回答</p>
        </div>
        <form action="<%=path%>/Answer/UpdateAnswer" role="form" style="margin-top: 50px;">
            <div class="form-group">
                <input id="answer_id" name="answer_id" type="hidden"
                       class="form-control" value=${answer.answer_id}></input>   <%-- 上传回答的编号 默认隐藏 --%>
            </div>
            <div class="form-group">
                <label for="answer_content">回答内容</label>
                <textarea id="answer_content" name="answer_content" class="form-control" rows="20">${answer.answer_content}</textarea>
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
