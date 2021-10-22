<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.write("out输出1<br>");
    out.flush();
    out.write("out输出2<br>");
    out.print(12);
    out.write(12);

//    jsp所有代码执行完成后 会执行out.flush()方法
    response.getWriter().write("response输出1 <br>");
    response.getWriter().write("response输出2 <br>");
%>
</body>
</html>
