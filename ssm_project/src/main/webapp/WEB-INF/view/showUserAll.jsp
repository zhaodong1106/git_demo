<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function formSubmit(url) {
		
		document.forms[0].action = url;
		document.forms[0].submit();
		
	}
	 function clickHandler() {
  alert("onclick attribute in html");
 }
</script>
</head>

<body>
	This is my JSP page,欢迎你，${sessionScope.userName }.员工列表信息
	<br>

	<c:if test="${empty requestScope.pageList.list }">
    	没有员工信息
    </c:if>
	<c:if test="${!empty requestScope.pageList.list }">
	<form method="post" >
	  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="clickHandler()">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('studentInsert');this.blur();return false;">新建</a></li>
<li id="update"><a href="#" onclick="formSubmit('showUserAll/update');this.blur();return false;">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('deleteUserBatch');this.blur();return false;">批量删除1</a></li>
<li id="delete"><a href="#" onclick="formSubmit('showUserAll/delete');this.blur();return false;">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('start.action','_self');this.blur();">启用</a></li>
<li id="new"><a href="#" onclick="formSubmit('stop.action','_self');this.blur();">停止</a></li>
<li id="print"><a href="#" onclick="formSubmit('print.action','_self');this.blur();">打印</a></li>
</ul>
  </div>
		<table border="1" cellpadding="10">
			<tr>
				<th>USER_ID</th>
				<th>USER_NAME</th>
				<th>USER_PASSWORD</th>
				<th>USER_EMAIL</th>
				<th>CLASS_NAME</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
			<c:forEach items="${requestScope.pageList.list }" var="user">
				<tr>
					<td><input type="checkbox" name="userId" value="${user.userId}" />
					<td>${user.userName}
					<td>${user.userPassword }
					<td>${user.userEmail }
					<td>${user.classes.className }
					<td><a href="showUserAll/update/${user.userId}"><input
							type="button" style="cursor:pointer" name="edit" value="EDIT" />
					</a>
					</td>
					<td><a href="showUserAll/delete/${user.userId}"><input
							type="button" style="cursor:pointer" name="delete" value="DELETE" />
					</a>
					</td>
				</tr>
			</c:forEach>


		</table>
		<input type="submit" value="修改"/>
		</form>
	</c:if>
	<%-- <a href="${requestScope.pageList.hasPreviousPage }==flase?showUserAll:(showUserAll?page=${requestScope.pageList.prePage })">prePage</a> --%>


	<a href="showUserAll?page=${requestScope.pageList.prePage }"><input
		type="button" style="cursor:pointer" value="prePage" />
	</a>

	<%--     <c:otherwise>
    <a href="showUserAll">prePage</a>
    </c:otherwise> --%>


	<a href="showUserAll?page=${requestScope.pageList.nextPage }"><input
		type="button" style="cursor:pointer" value="nextPage" />
	</a>

	<%--     <c:otherwise>
    <a href="showUserAll?page=${requestScope.pageList.lastPage }">nextPage</a>
    </c:otherwise> --%>

	<br> prePage:${requestScope.pageList.prePage }
	<br> ${requestScope.pageList.hasPreviousPage }
	<br>
	<br> nextPage:${requestScope.pageList.nextPage }
	<br> ${requestScope.pageList.hasNextPage }
	<br> <% out.println("getContextPath:"+request.getQueryString());%>
</body>
</html>
