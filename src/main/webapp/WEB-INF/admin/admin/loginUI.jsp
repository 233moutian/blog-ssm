<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>
        管理员登陆
    </title>
    <meta charset="utf-8">
    <%@ include file="../se7en_css.jsp" %>
    <%@ include file="../se7en_js.jsp" %>
    <script src="${pageContext.request.contextPath}/resources/lib/messenger/build/js/messenger.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/lib/messenger/build/css/messenger.css"  rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/lib/messenger/build/css/messenger-theme-air.css"  rel="stylesheet" type="text/css" />

    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
</head>
<body class="login2">
<!-- Login Screen -->
<div class="login-wrapper">

    <h3 style="margin-top: 30%">管理员登陆</h3>
    <form action="${pageContext.request.contextPath}/admin/admin/login" id="admin-form" method="post">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-user"></i></span>
                <input class="form-control" placeholder="登陆名" required name="account" type="text">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-lock"></i></span>
                <input class="form-control" placeholder="密码" required type="password" name="password">
            </div>
        </div>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="登录">
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("#admin-form").validate({
            rules: {
                aid: {
                    required:true,
                    number:true,
                },
                password: "required",
            },
            messages: {
                aid: {
                    required: "请填写你的姓名",
                },
                password: "请填写您的密码",
            }
        });
    });
</script>
</body>
<c:if test="${result!=null}">
    <script>
        $().ready(function(){
            var success=${result.success};
            var msg='${result.msg}';
            var type="error";
            if(success=true){
                type="success"
            }
            Messenger.options = {
                extraClasses: 'messenger-fixed messenger-on-top messenger-on-right',
                theme: 'future'
            }
            $.globalMessenger().post({  message:"提示："+ msg,
                type: 'error',
                showCloseButton: true})

        })
    </script>
</c:if>
</html>