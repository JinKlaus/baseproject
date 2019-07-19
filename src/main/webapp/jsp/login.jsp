<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div id="loginDiv">
<form id="loginForm" action="login.do" method="post">
    用户ID:<input type="text" id="userTxt" name="usrId">
    用户密码:<input type="password" id="pwdTxt" name="pwd">
    <button type="submit" id="loginBtn">登录</button>
</form>
</div>
<script src="../webRes/jquery/js/jquery-3.3.1.min.js"></script>
<script src="../webRes/jquery/js/jquery-migrate-1.4.1.min.js"></script>
<script src="../js/login.js"></script>
</body>
</html>