<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 21:05
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
pageContext域是否有值： <%=pageContext.getAttribute("key")%> <br>
request域是否有值： <%=request.getAttribute("key")%><br>
session域是否有值： <%=session.getAttribute("key")%><br>
application域是否有值： <%=application.getAttribute("key")%>

<%
    request.getRequestDispatcher("/scope2.jsp").forward(request,response);
%>
<%--请求转发--%>
<jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>
