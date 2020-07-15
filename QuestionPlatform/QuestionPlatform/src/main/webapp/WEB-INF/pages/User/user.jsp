<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/9
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户页面</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4" style="text-align: left">
                <div class="row">
                    <div style="height: 100px;text-align: center;">
                        <p style="font-size: 30px;margin-top: 50px;">欢迎您！${login_user_nickname}</p>
                    </div>
                    <div class="row">
                        <div class="col-md-6" style="text-align: right;">
                            <a href="<%=path%>/User/DisplayMyInfo"><button class="btn btn-info btn-lg" style="width: 150px;">个人资料</button></a>
                        </div>
                        <div class="col-md-6" style="text-align: left;">
                            <a href="<%=path%>/Login/LoginOut"><button class="btn btn-danger btn-lg" style="width: 150px;">退出登录</button></a>
                        </div>
                    </div>
                    <div style="height: 700px;margin-top: 20px">
                        <ul class="nav nav-tabs nav-stacked" role="tablist">
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfToUser" style="font-size: 20px;">关注的用户</a>
                            </li>
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfFromUser" style="font-size: 20px;">我的粉丝</a>
                            </li>
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfToQuestion" style="font-size: 20px;">关注的问题</a>
                            </li>
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfToAnswer" style="font-size: 20px;">赞同的回答</a>
                            </li>
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfAskQuestion" style="font-size: 20px;">提出的问题</a>
                            </li>
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfMakeAnswer" style="font-size: 20px;">做出的回答</a>
                            </li>
                            <li role="presentation" style="text-align: center;height: 100px">
                                <a href="<%=path%>/User/FindOfAskComment" style="font-size: 20px;">做出的评论</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="row" style="margin-top: 20%;height: 100px">
                    <div class="col-md-12">
                        <form action="<%=path%>/Question/DisplayQuestionListByCondition" class="form-inline" role="form" method="post">
                            <div class="form-group " >
                                <input type="text" class="form-control" id="input_question_title" name="input_question_title" style="width: 800px;"
                                       required="true" autocomplete="off" placeholder="请输入问题标题的关键字"/>
                                <button type="submit" class="btn btn-info">查询问题</button>
                            </div>
                        </form>
                    </div>
                    <div class="row">
                        <div class="col-md-6" style="margin-top: 100px;text-align: center;">
                            <a href="<%=path%>/Question/AskQuestion"><button type="button" class="btn btn-primary btn-lg" style="width: 150px;">提出问题</button></a>
                        </div>
                        <div class="col-md-6" style="margin-top: 100px;text-align: left;">
                            <a href="<%=path%>/Question/DisplayAllQuestionList"><button type="button" class="btn btn-success btn-lg" style="width: 150px;">查看所有问题</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>