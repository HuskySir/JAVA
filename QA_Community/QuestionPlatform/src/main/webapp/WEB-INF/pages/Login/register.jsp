<%--
  Created by IntelliJ IDEA.
  User: 42930
  Date: 2020/7/10
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>

    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap-theme.css">

    <script src="<%=path%>/js/jquery-3.5.1.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>

<script language="JavaScript">
    $(document).ready(function(){
        $('#user_password').on('input propertychange', function() {
            //input propertychange即实时监控键盘输入包括粘贴
            var user_password = $.trim($(this).val());
            //获取this，即user_password的val()值，trim函数的作用是去除空格
            var user_password_verify = $.trim($("#user_password_verify").val());

            if(user_password==""&&user_password_verify==""){                        //密码为空
                //若都为空，则提示密码不能为空，为了用户体验（在界面上用required同时做了处理）
                $("#msg_pwd").html("<font color='red'>密码不能为空</font>");
                $("#register").attr("disabled", true); //不能进行注册
            } else {
                if (user_password != user_password_verify){                      //密码不同
                    $("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
                    $("#register").attr("disabled", true);                              //不能进行注册
                } else {
                    if (user_password.length<6||user_password_verify<6) {
                        //若密码长度小于6，进行提示
                        $("#msg_pwd").html("<font color='red'>密码长度不能小于6</font>");
                        $("#register").attr("disabled", true);                         //不能进行注册
                    } else {
                        //满足要求
                        $("#msg_pwd").html("<font color='green'>密码满足要求，请点击注册按钮</font>");
                        $("#register").attr("disabled", false);                       //可以进行注册
                    }
                }
            }
        })
    })

    $(document).ready(function(){
        $('#user_password_verify').on('input propertychange', function() {
            //input propertychange即实时监控键盘输入包括粘贴
            var user_password_verify = $.trim($(this).val());
            //获取this，即user_password的val()值，trim函数的作用是去除空格
            var user_password = $.trim($("#user_password").val());

            if(user_password==""&&user_password_verify==""){                        //密码为空
                //若都为空，则提示密码不能为空，为了用户体验（在界面上用required同时做了处理）
                $("#msg_pwd").html("<font color='red'>密码不能为空</font>");
                $("#register").attr("disabled", true); //不能进行注册
            } else {
                if (user_password != user_password_verify){                      //密码不同
                    $("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
                    $("#register").attr("disabled", true);                              //不能进行注册
                } else {
                    if (user_password.length<6||user_password_verify<6) {
                        //若密码长度小于6，进行提示
                        $("#msg_pwd").html("<font color='red'>密码长度不能小于6</font>");
                        $("#register").attr("disabled", true);                         //不能进行注册
                    } else {
                        //满足要求
                        $("#msg_pwd").html("<font color='green'>密码满足要求，请点击注册按钮</font>");
                        $("#register").attr("disabled", false);                       //可以进行注册
                    }
                }
            }
        })
    })

</script>

<div class="container-fluid">
    <div class="col-md-4 col-md-offset-4">
        <div style="text-align: center;margin-top: 300px;">
            <h1>用户注册</h1>
        </div>
        <div style="margin-top: 20px">
            <form action="<%=path%>/Register/SaveUser" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="user_nickname" class="col-md-4 control-label">用户昵称：</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="user_nickname" name="user_nickname" maxlength="20" required="true" placeholder="最大长度20位">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">性别：</label>
                    <div class="col-md-8">
                        <input type="radio" name="user_sex" value="男" checked="checked">男
                        <input type="radio" name="user_sex" value="女">女
                    </div>
                </div>
                <div class="form-group">
                    <label for="user_email" class="col-md-4 control-label">邮箱：</label>
                    <div class="col-md-8">
                        <input type="email" class="form-control" id="user_email" name="user_email" maxlength="30" required="true" placeholder="最大长度20位">
                    </div>
                </div>
                <div class="form-group">
                    <label for="user_name" class="col-md-4 control-label">用户名：</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="user_name" name="user_name" maxlength="16"
                               onkeyup="this.value=this.value.replace(/[^\w_]/g,'');" required="true" placeholder="请输入英文字母、数字、下划线组合，最大长度16位">
                    </div>
                </div>
                <div class="form-group">
                    <label for="user_password" class="col-md-4 control-label">密码：</label>
                    <div class="col-md-8">
                        <input type="password" class="form-control" id="user_password" name="user_password" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"
                               minlength="6" maxlength="16" required="true" placeholder="请输入6-16位英文字母、数字组合">
                    </div>
                </div>
                <div class="form-group">
                    <label for="user_password_verify" class="col-md-4 control-label">确认密码：</label>
                    <div class="col-md-8">
                        <input type="password" class="form-control" id="user_password_verify" name="user_password_verify" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"
                               minlength="6" maxlength="16" required="true" placeholder="请输入6-16位英文字母、数字组合">
                    </div>
                </div>
                <p id="msg_pwd" style="margin-left: 150px"></p>
                <div class="col-md-offset-6 col-md-4">
                    <button id="register" type="submit" class="btn btn-success">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
