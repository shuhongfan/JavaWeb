<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%--		静态包含 base标签、css样式、jquery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%--		静态包含manager管理模块的菜单--%>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="post">
<%--				可以在请求发起时，附带上当前要操作的值，并注入到隐藏域中--%>
<%--				可以通过判断当前请求参数是否包含有id参数；如果有说明是修改操作；如果没有说明是添加操作--%>
<%--	可以通过判断当前request域中是否包含有id参数。如果有说明是修改操作。如果没有说明是添加操作--%>
<%--				<input type="hidden" name="action" value="${param.method}">--%>
				<input type="hidden" name="action" value="${empty param.id?"add":"update"}">
				<input type="hidden" name="id" value="${book.id}">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${book.name}"/></td>
						<td><input name="price" type="text" value="${book.price}"/></td>
						<td><input name="author" type="text" value="${book.author}"/></td>
						<td><input name="sales" type="text" value="${book.sales}"/></td>
						<td><input name="stock" type="text" value="${book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%--	静态包含页脚内容--%>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>