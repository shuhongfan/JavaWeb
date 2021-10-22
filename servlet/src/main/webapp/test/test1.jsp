<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
<%
    for (int i = 1; i < 10; i++) {
%>
    <tr>
<%
        for (int j = 1; j <= i; j++) {
%>
         <td><%=j+"*"+i+"="+(i*j)%></td>
<%
        }
%>
    </tr>
<%
    }
%>
</table>
</body>
</html>
