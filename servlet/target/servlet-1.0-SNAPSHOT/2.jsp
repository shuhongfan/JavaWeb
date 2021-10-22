<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--声明脚本--%>
<%--声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%--声明static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }
%>
<%--声明类方法--%>
<%!
    public int abc(){
        return 12;
    }
%>
<%--声明内部类--%>
<%!
    public static class A{
        private Integer id=12;
        private String abc="abc";
    }
%>

<%--表达式脚本--%>

<%=12%> <br>
<%=12.12%> <br>
<%="我是字符串"%> <br>
<%=map%> <br>
<%=request.getParameter("username")%> <br>


<%--代码脚本--%>
<%
    int i=12;
    if (i==12) System.out.println("i==12");
    else System.out.println(i!=12);
%>
<%
    for (int k = 0; k < 10; k++) {
%>
<%=k%>
<%
        System.out.println(k);
    }
%>

<%
    String username = request.getParameter("username");
    System.out.println("用户名的请求参数为："+username);
%>

<table border="1">
    <%
        for (int j = 0; j < 10; j++) {
    %>
        <tr>
            <td>第<%=j%>行</td>
        </tr>
    <%
        }
    %>

<%--    html注释--%>
    <%
//        java注释
    %>
    <%-- JSP注释 --%>

<%--    request 请求对象--%>
<%--    response 响应对象--%>
<%--    pageContext  jsp上下文对象--%>
<%--    session  会话对象--%>
<%--    application ServletContext对象--%>
<%--    config servletConfig对象--%>
<%--    out  jsp输出流对象--%>
<%--    page  指向当前jsp对象--%>

<%--    四大域对象--%>
<%--    pageContext  当前jsp页面范围内有效--%>
<%--    request  一次请求内有效--%>
<%--    session  一个会话范围内有效  打开浏览器访问服务器，直到关闭浏览器--%>
<%--    application  整个web工程范围内有效  只要web工程不停止，数据都在--%>
</table>
</body>
</html>
