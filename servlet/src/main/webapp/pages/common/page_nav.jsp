<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/21
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${page.pageNo>1}">
        <a href="${page.url}&pageNo=1">首页</a>
        <a href="${page.url}&pageNo=${page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <%--			情况1 如果总页码小于等于5 页码的范围是1----总页码--%>
        <c:when test="${page.pageTotal<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${page.pageTotal}"/>
        </c:when>
        <%--				情况2 总页码大于5--%>
        <c:when test="${page.pageTotal>5}">
            <c:choose>
                <%--					小情况1 当前页码前面3个：1,2,3的情况，页码范围是 1-5--%>
                <c:when test="${page.pageNo<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--						小情况2 当前页码为最后3个 8 9 10 ， 页码范围是 总页码-4-----总页码--%>
                <c:when test="${page.pageNo>page.pageTotal-3}">
                    <c:set var="begin" value="${page.pageTotal-4}"/>
                    <c:set var="end" value="${page.pageTotal}"/>
                </c:when>
                <%--						小情况3  4 5 6 7，页码范围是：当前页码减2--当前页码+2--%>
                <c:otherwise>
                    <c:set var="begin" value="${page.pageNo-2}"/>
                    <c:set var="end" value="${page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i==page.pageNo}">
            <a href="${page.url}&pageNo=${i}">【${i}】</a>
        </c:if>
        <c:if test="${i!=page.pageNo}">
            <a href="${page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${page.pageNo<page.pageTotal}">
        <a href="${page.url}&pageNo=${page.pageNo+1}">下一页</a>
        <a href="${page.url}&pageNo=${page.pageTotal}">末页</a>
    </c:if>
    共${page.pageTotal}页，${page.pageTotalCount}条记录
    到第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" value="确定" id="searchBtn">
</div>
<script>
    $(function () {
        $("#searchBtn").click(function () {
            let input = $("#pn_input").val()
            if (input<1) alert("页码不能小于1页")
            else if (input>${page.pageTotal}) alert("不能大于 ${page.pageTotal} 页")
            else
                location.href="${page.url}&pageNo="+input
        })
    })
</script>