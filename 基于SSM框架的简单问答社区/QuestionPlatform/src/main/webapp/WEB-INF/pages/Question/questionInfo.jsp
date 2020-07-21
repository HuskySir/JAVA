<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/14
  Time: 12:57
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
    <title>问题详细信息</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>

    <script language="JavaScript">
        function DeleteQuestion(){
            var question_id = ${question.question_id};      //问题编号

            $.ajax({
                url:"<%=path%>/Question/DeleteQuestion",
                type:"POST",
                async: false,
                contentType:"application/json;charset=UTF-8",
                dataType:'json',
                data:JSON.stringify({"question_id":question_id}), //JSON对象转为字符串
                success:function(data){
                    if (data == true) {
                        window.history.go(-1);
                        alert("删除成功");
                    } else {
                        alert("删除失败");
                    }
                }
            });
        }
    </script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-6 col-md-offset-3">
        <div style="text-align: center;margin-top: 100px;">
            <p style="font-size: 50px;">问题页面</p>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title" style="text-align: center;">
                    <h2>${question.question_title}</h2>
                </div>
            </div>
            <div class="panel-body">
                <h5>${question.question_content}</h5>
            </div>
            <div class="row" style="margin-left: 10px;">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <h5>关注量：${question.question_follow_count}</h5>
                        </div>
                        <div class="col-md-6">
                            <h5>回答量：${question.question_answer_count}</h5>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <h5>更新时间：<fmt:formatDate value="${question.question_update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                        </div>
                        <div class="col-md-6">
                            <h5>创建时间：<fmt:formatDate value="${question.question_create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${AskByMyself eq true}">
            <div class="row">
                <div class="col-md-4" style="text-align: center;">
                    <a href="<%=path%>/Question/DisplayUpdateQuestion?question_id=${question.question_id}">
                        <button type="button" class="btn btn-success" style="width: 150px;">修改问题</button>
                    </a>
                </div>
                <div class="col-md-4" style="text-align: center;">
                    <a href="javascript:history.go(0)"><button class="btn btn-info" style="width: 150px;">刷新问题</button></a>
                </div>
                <div class="col-md-4" style="text-align: center;">
                    <button class="btn btn-warning" style="width: 150px;" onclick="DeleteQuestion()">删除问题</button>
                </div>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
