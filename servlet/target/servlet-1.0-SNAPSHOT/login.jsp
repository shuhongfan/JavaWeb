<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/22
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="loginServletTest" method="post">
    用户名： <input type="text" name="username" value="${cookie.username.value}"> <br>
    密码： <input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
