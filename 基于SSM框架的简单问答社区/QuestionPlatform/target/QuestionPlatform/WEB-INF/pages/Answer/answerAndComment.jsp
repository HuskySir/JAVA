<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/12
  Time: 19:42
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
    <title>回答及评论</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

    <script language="JavaScript">
        function SaveUserSupportAnswer(){
            var login_user_id = ${login_user_id};              //登录者编号
            var answer_id = ${answer.answer_id};          //回答编号

            $.ajax({
                url:"<%=path%>/UserRelation/SaveUserSupportAnswer",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',

                data:JSON.stringify({"from_user_id":login_user_id,"to_answer_id":answer_id}), //JSON对象转为字符串
                success:function(data){
                    if (data == true) {
                        alert("赞同成功");
                    } else {
                        alert("您已赞同该问题，不可重复赞同")
                    }
                }
            });
        }

        function DeleteUserSupportAnswer(){
            var login_user_id = ${login_user_id};             //登录者编号
            var answer_id = ${answer.answer_id}; //问题编号

            $.ajax({
                url:"<%=path%>/UserRelation/DeleteUserSupportAnswer",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',

                data:JSON.stringify({"from_user_id":login_user_id,"to_answer_id":answer_id}), //JSON对象转为字符串
                success:function(data){
                    if (data == true) {
                        alert("取消赞同成功");
                    } else {
                        alert("您还未赞同该问题，不可取消赞同")
                    }
                }
            });
        }
    </script>
</head>
<body>

<div class="container">
    <div class="row" style="text-align: center;">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h1 class="panel-title">回答</h1>
            </div>
            <div class="row panel-body" style="text-align: left;margin-left: 10px;">
                <div>
                    <h6>${answer.answer_content}</h6>
                </div>
            </div>
            <div class="row" style="text-align: center;margin-top: 10px;">
                <div class="col-md-2" style="text-align: center;">
                        <h5>回答者：<a href="<%=path%>/User/DisplayUserInfo?user_id=${make_answer_user.user_id}">${make_answer_user.user_nickname}</a></h5>
                </div>
                <%--<div class="col-md-4" style="text-align: center;">
                    <h5>浏览量:${answer.answer_view_count}</h5>  目前不提供浏览量功能
                </div>--%>
                <div class="col-md-2" style="text-align: center;">
                    <h5>赞同量:${answer.answer_agree_count}</h5>
                </div>
                <div class="col-md-2" style="text-align: center;">
                    <h5>评论量:${comments.size()}</h5>
                </div>
                <div class="col-md-3" style="text-align: center;">
                    <h5>更新时间:<fmt:formatDate value="${answer.answer_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                </div>
                <div class="col-md-3" style="text-align: center;">
                    <h5>创建时间<fmt:formatDate value="${answer.answer_create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <a href="<%=path%>/Comment/MakeComment?answer_id=${answer.answer_id}"><button class="btn btn-info" style="width: 150px;">我要评论</button></a>
            </div>
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-6" style="text-align: right;">
                        <a><button class="btn btn-success" style="width: 150px;" onclick="SaveUserSupportAnswer()">赞同该回答</button></a>
                    </div>
                    <div class="col-md-6" style="text-align: left;">
                        <a><button class="btn btn-danger" style="width: 150px;" onclick="DeleteUserSupportAnswer()">取消赞同该回答</button></a>
                    </div>
                </div>
            </div>
        </div>

        <c:forEach items="${comments}" var="comment" varStatus="loop">
            <div class="panel panel-warning" style="margin-top: 10px">
                <div class="row" style="text-align: left;margin-left: 20px;">
                    <div class="panel-heading" style="text-align: left;margin-left: 10px">
                        <h1 class="panel-title">评论：${loop.count}楼</h1>
                    </div>
                    <div class="row panel-body" style="text-align: left;margin-left: 20px;">
                        <div style="margin-right: 50px">
                            <h6>${comment.comment_content}</h6>
                        </div>
                    </div>
                </div>
                <div class="row" style="text-align: right;margin-top: 10px;">
                    <%--<div class="col-md-4" style="text-align: center;">   暂不提供下级评论
                        <h5>
                            <a href="<%=path%>/CommentController/DisplayNextCommentInfo?comment_id=${comment.comment_id}">
                            详细内容
                            </a>
                        </h5>
                    </div>--%>
                    <div class="col-md-6" style="text-align: center;">
                        <h5>评论者：<a href="<%=path%>/User/DisplayUserInfo?user_id=${make_comment_users[loop.index].user_id}">${make_comment_users[loop.index].user_nickname}</a></h5>
                    </div>
                    <div class="col-md-6" style="text-align: center;">
                        <h5>评论时间：<fmt:formatDate value="${comment.comment_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                    </div>
                </div>
            </div>
        </c:forEach>
      <div>
</div>
</body>
</html>
