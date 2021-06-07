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
    <title>修改评论</title>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-4 col-md-offset-4">
        <div style="text-align: center;margin-top: 100px;">
            <p style="font-size: 50px;">修改评论</p>
        </div>
        <form action="<%=path%>/Comment/UpdateComment" role="form" style="margin-top: 50px;">
            <div class="form-group">
                <input id="comment_id" name="comment_id" type="hidden"
                       class="form-control" value=${comment.comment_id}></input>   <%-- 上传评论的编号 默认隐藏 --%>
            </div>
            <div class="form-group">
                <label for="comment_content">评论内容</label>
                <textarea id="comment_content" name="comment_content" class="form-control" rows="20">${comment.comment_content}</textarea>
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
