<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/12
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户详细信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

    <script language="JavaScript">
        function SaveUserFollowUser(){
            var login_user_id = ${login_user_id}        //登录者（发起者）编号
            var user_id = ${user.user_id};              //接受者用户编号

            $.ajax({
                url:"<%=path%>/UserRelation/SaveUserFollowUser",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',

                data:JSON.stringify({"from_user_id":login_user_id,"to_user_id":user_id}), //JSON对象转为字符串
                success:function(data){
                    /* 可在后端增加判断发起者和接受者用户是否是同一用户的判断 */
                    if (data == true) {
                        alert("关注成功");
                    } else {
                        alert("您已经关注该用户，不可重复关注")
                    }
                }
            });
        }

        function DeleteUserFollowUser(){
            var login_user_id = ${login_user_id}        //登录者（发起者）编号
            var user_id = ${user.user_id};              //接受者用户编号

            $.ajax({
                url:"<%=path%>/UserRelation/DeleteUserFollowUser",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',

                data:JSON.stringify({"from_user_id":login_user_id,"to_user_id":user_id}), //JSON对象转为字符串
                success:function(data){
                    if (data == true) {
                        alert("取消关注成功");
                    } else {
                        alert("您还未关注该用户，不可取消关注")
                    }
                }
            });
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div style="text-align: center;margin-top: 300px;">
        <div>
            <h1>用户名：${user.user_name}</h1>
            <h1>用户昵称：${user.user_nickname}</h1>
        </div>
        <div>
            <h1>关注数：${userRelation.to_user_count}</h1>
            <h1>粉丝数：${userRelation.from_user_count}</h1>
            <h1>提出的问题数：${userRelation.ask_question_count}</h1>
            <h1>做出的回答数：${userRelation.make_answer_count}</h1>
            <h1>做出的评论数：${userRelation.make_comment_count}</h1>
            <div class="row">
                <div class="col-md-6">
                    <div style="text-align: right">
                        <button class="btn btn-success" style="width: 100px" onclick="SaveUserFollowUser()">关注用户</button>
                    </div>
                </div>
                <div class="col-md-6">
                    <div style="text-align: left">
                        <button class="btn btn-danger" style="width: 100px" onclick="DeleteUserFollowUser()">取消关注</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
