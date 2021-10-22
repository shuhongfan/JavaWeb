<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/20
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String scheme = request.getScheme();
    String basePath = scheme + "://" +
            request.getServerName() +
            ":" + request.getServerPort() +
            request.getContextPath() +
            "/";
%>

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>