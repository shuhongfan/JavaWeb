<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
pageContext域是否有值： <%=pageContext.getAttribute("key")%> <br>
request域是否有值： <%=request.getAttribute("key")%><br>
session域是否有值： <%=session.getAttribute("key")%><br>
application域是否有值： <%=application.getAttribute("key")%>
</body>
</html>
