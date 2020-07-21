<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/12
  Time: 15:14
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
    <title>问题及回答</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

    <script language="JavaScript">
        function SaveUserFollowQuestion(){
            var login_user_id = ${login_user_id};        //登录者编号
            var question_id = ${question.question_id};  //问题编号

            $.ajax({
                url:"<%=path%>/UserRelation/SaveUserFollowQuestion",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',

                data:JSON.stringify({"from_user_id":login_user_id,"to_question_id":question_id}), //JSON对象转为字符串
                success:function(data){
                    if (data == true) {
                        alert("关注成功");
                    } else {
                        alert("您已经关注该问题，不可重复关注")
                    }
                }
            });
        }

        function DeleteUserFollowQuestion(){
            var login_user_id = ${login_user_id};       //登录者编号
            var question_id = ${question.question_id}; //问题编号

            $.ajax({
                url:"<%=path%>/UserRelation/DeleteUserFollowQuestion",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',

                data:JSON.stringify({"from_user_id":login_user_id,"to_question_id":question_id}), //JSON对象转为字符串
                success:function(data){
                    if (data == true) {
                        alert("取消关注成功");
                    } else {
                        alert("您还未关注该问题，不可取消关注")
                    }
                }
            });
        }
    </script>
</head>
<body>

<div class="container">
    <div class="row" style="text-align: center;">
        <div class="panel panel-success">
            <div class="panel panel-heading">
                <h1 class="panel-title"><strong>问题：${question.question_title}</strong></h1>
            </div>
            <div class="row" style="text-align: right;">
                <div style="margin-right: 100px;">
                    <h4><a href="<%=path%>/User/DisplayUserInfo?user_id=${ask_question_user.user_id}">${ask_question_user.user_nickname}</a></h4>
                </div>
            </div>

            <div class="row panel-body" style="text-align: left;margin-left: 10px;">
                <div style="margin-right: 50px">
                    <h6>${question.question_content}</h6>
                </div>
            </div>

            <div class="row" style="text-align: center;margin-top: 10px;">
                <%--<div class="col-md-4" style="text-align: center;">
                    <h5>浏览量：${question.question_view_count}</h5>     目前不提供浏览量功能
                </div>--%>
                <div class="col-md-3" style="text-align: center;">
                    <h5>关注量:${question.question_follow_count}</h5>
                </div>
                <div class="col-md-3" style="text-align: center;">
                    <h5>回答量:${answers.size()}</h5>
                </div>
                <div class="col-md-3" style="text-align: center;">
                    <h5>更新时间:<fmt:formatDate value="${question.question_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                </div>
                <div class="col-md-3" style="text-align: center;">
                    <h5>创建时间:<fmt:formatDate value="${question.question_create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <a href="<%=path%>/Answer/MakeAnswer?question_id=${question.question_id}"><button class="btn btn-info" style="width: 150px;">我要回答</button></a>
            </div>
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-6" style="text-align: right;">
                        <button class="btn btn-success" style="width: 150px;" onclick="SaveUserFollowQuestion()">关注该问题</button>
                    </div>
                    <div class="col-md-6" style="text-align: left;">
                        <button class="btn btn-danger" style="width: 150px;" onclick="DeleteUserFollowQuestion()">取消关注该问题</button>
                    </div>
                </div>
            </div>
        </div>

        <c:forEach items="${answers}" var="answer" varStatus="loop">
            <div class="panel panel-info" style="margin-top: 10px">
                <div class="row">
                    <div class="panel-heading" style="text-align: left;margin-left: 10px;">
                        <h1 class="panel-title">回答:${loop.count}楼</h1>
                    </div>
                    <div class="row panel-body" style="text-align: left;margin-left: 20px;">
                        <div style="margin-right: 50px">
                            <h6>${answer.answer_content}</h6>
                        </div>
                    </div>
                    <div class="row" style="text-align: right;margin-top: 10px;">
                        <div class="col-md-2">
                            <a href="<%=path%>/Answer/DisplayAnswerAndComment?answer_id=${answer.answer_id}">
                                <h5>详细内容</h5>
                            </a>
                        </div>
                        <div class="col-md-2" style="text-align: center;">
                            <h5>回答者:${make_answer_users[loop.index].user_nickname}</h5>
                        </div>
                        <div class="col-md-2" style="text-align: center;">
                            <h5>赞同量:${answer.answer_agree_count}</h5>
                        </div>
                        <div class="col-md-2" style="text-align: center;">
                            <h5>评论量:${first_comment_counts[loop.index]}</h5>
                        </div>
                        <div class="col-md-4" style="text-align: center;">
                            <h5>最近回答时间:<fmt:formatDate value="${answer.answer_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
