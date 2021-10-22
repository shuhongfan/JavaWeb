<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shf.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student((i+1),"name"+(i+1),(18+i),"phone"+i));
        }
    %>
    <table border="1" style="border-collapse: collapse">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>电话</td>
        </tr>
    <%
        for (Student s:students){
    %>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getPhone()%></td>
    </tr>
    <%
        }
    %>
    </table>
</body>
</html>
