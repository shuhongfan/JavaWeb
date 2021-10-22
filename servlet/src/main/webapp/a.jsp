<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/20
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>

表达式脚本输出：  <%=request.getAttribute("key")%>  <br>
EL表达式输出key值 ： ${key} <br>
${requestScope.key} <br>
${sessionScope.key} <br>
${applicationScope.key} <br>

<%--el表达式输出null值的时候是 空串--%>
<%--el表达式会从小到大域中取出数据--%>
<%--表达式脚本输出null值的时候是  null--%>
<hr>
${param} <br>
${param.username} <br>
${param.pwd}<br>
${param.hobby}<br>

${paramValues.hooby[0]}<br>
${paramValues.hooby[1]}<br>
${header['User-Agent']} <br>
${header.Connection} <br>
${headerValues['User-Agent'][0]} <br>
${cookie.JSESSIONID.name}
${cookie.JSESSIONID.value}
${initParam}
${initParam.username}
${initParam.password}
</body>
</html>
