<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shf.pojo.StudentJSTL" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/20
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--set标签可以往域中传递数据--%>
<%--scope属性设置保存到哪个域--%>
<%--request表示request域--%>
<%--session表示Session域--%>
<%--application表示Servlet--%>
<c:set scope="request" var="abc" value="abcValue"/>
${requestScope.abc}

<%--if标签用来做if判断--%>
<%--test属性表示判断的条件 使用el表达式输出--%>
<c:if test="${12==12}">
    <h1>12等于12</h1>
</c:if>
<c:if test="${12!=12}">
    <h1>12不等于12</h1>
</c:if>

<%--choose、when、otherwise--%>
<%--choose开始每一种判断--%>
<%--when标签表示每一种判断情况--%>
<%--otherwise表示剩下的情况--%>
<%
    request.setAttribute("height",178);
%>
<c:choose>
    <c:when test="${requestScope.height>190}">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${requestScope.height>180}">
        <h2>很高</h2>
    </c:when>
    <c:when test="${requestScope.height>170}">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
        <h2>不高</h2>
        <c:choose>
            <c:when test="${requestScope.height>160}">
                <h2>160</h2>
            </c:when>
        </c:choose>
    </c:otherwise>
</c:choose>

<%--遍历--%>
<%--begin开始索引--%>
<%--end结束索引--%>
<%--var属性循环的变量--%>
<table border="1">
    <c:forEach var="i" begin="1" end="10">
        <tr>第${i}行</tr>
    </c:forEach>
</table>

<%--遍历对象类型数组--%>
<%--item表示遍历的数据源 遍历的集合--%>
<%--var 表示当前遍历到的数据--%>
<%--begin开始索引--%>
<%--end结束索引--%>
<%--step步长--%>
<%--varStuatus状态--%>
<%
    request.setAttribute("arr",new String[]{"1863545646","456456","564564"});
%>
<c:forEach items="${requestScope.arr}" var="i">
    ${i}
</c:forEach>
<hr>

<%
    HashMap<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    request.setAttribute("map",map);
%>
<c:forEach items="${requestScope.map}" var="entry">
    ${entry}
    <h1>${entry.key}===========${entry.value}</h1>
</c:forEach>

<%
    ArrayList<StudentJSTL> studentJSTLS = new ArrayList<>();
    for (int i = 1; i < 11; i++) {
        studentJSTLS.add(new StudentJSTL(i,"username"+i,"pass"+1,18+i,"1564"+i));
    }
    request.setAttribute("stus",studentJSTLS);
%>
<table border="1">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    <c:forEach begin="2" end="6" step="2" varStatus="status" items="${requestScope.stus}" var="stu">
<%--        ${stu}--%>
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.index}</td>
            <td>${status.count}</td>
            <td>${status.first}</td>
            <td>${status.last}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
