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
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
	$(function(){
	
	$(".showUser").click(function(){
		
		
		var url="jsonReturnUser";
		var args={userId:$(this).val()};
		$.post(url,args,function(data){
	var datasum="";
for(var i=0;i<data.length;i++){
datasum=datasum+","+data[i].userName;
}

$("#wrnmmp").text(datasum);	
		});
	});
 });
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
	This is my JSP page.员工列表信息
	<br>
	userName1:${requestScope.userName }<br>
	userName2:${sessionScope.userName }<br>
	userName3:${userName }<br>

	<c:if test="${empty requestScope.pageList.list }">
    	没有员工信息
    </c:if>
	<c:if test="${!empty requestScope.pageList.list }">
	<form method="post" >
	  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="clickHandler()">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('classInsert');this.blur();return false;">新建</a></li>
<li id="update"><a href="#" onclick="formSubmit('showClassAll/update');this.blur();return false;">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除1</a></li>
<li id="delete"><a href="#" onclick="formSubmit('showClassAll/delete');this.blur();return false;">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('classesShowUser','_self');this.blur();;return false;">查看学生学生</a></li>
<li id="new"><a href="#" onclick="formSubmit('stop.action','_self');this.blur();">停止</a></li>
<li id="print"><a href="#" onclick="formSubmit('print.action','_self');this.blur();">打印</a></li>
</ul>
  </div>
		<table border="1" cellpadding="10">
			<tr>
				<th>CLASS_ID</th>
				<th>CLASS_NAME</th>
				<th>USER_NAME</th>
				

			</tr>
			<c:forEach items="${requestScope.pageList.list }" var="classes">
				<tr>
					<td><input   type="checkbox" name="userId" value="${classes.classId}" />
					<td>${classes.className}

					</td>
					<td><input class="showUser"  value="${classes.classId}" type="button" /><div class="jsonUser" ></div></td>
					
				</tr>
			</c:forEach>


		</table>
		<input type="submit" value="修改"/>
		</form>
	</c:if>
	<%-- <a href="${requestScope.pageList.hasPreviousPage }==flase?showUserAll:(showUserAll?page=${requestScope.pageList.prePage })">prePage</a> --%>


	<a href="showClassAll?page=${requestScope.pageList.prePage }"><input
		type="button" style="cursor:pointer" value="prePage" />
	</a>

	<%--     <c:otherwise>
    <a href="showUserAll">prePage</a>
    </c:otherwise> --%>


	<a href="showClassAll?page=${requestScope.pageList.nextPage }"><input
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
	<br> out.println("asdasda");
	<br><button id="test"></button>
	<div id="wrnmmp"></div>
</body>
</html>
