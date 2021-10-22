<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>头部信息</h1>
<h1>主体内容</h1>

<%--静态包含--%>
<%--<%@ include file="/include/footer.jsp"%>--%>

<%--动态包含--%>
<%--会把包含的jsp页面翻译成java代码--%>
<jsp:include page="/include/footer.jsp">
    <jsp:param name="username" value="bbj"/>
    <jsp:param name="password" value="root"/>
</jsp:include>
</body>
</html>
