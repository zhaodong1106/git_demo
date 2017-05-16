<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentInsert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <br>
    <form method="post" action="insertOneStudent">

    	用户名：<input name="userName" value=""/>
    	用户密码：<input name="userPassword" />
    	用户邮箱：<input name="userEmail">
    <select name="classesId" >
    	<option value="">--请选择--</option>
    	<c:forEach  items="${classesList }" var="c">
    	<option   value="${c.classId}">${c.className }</option>
    	</c:forEach>
    </select>
    <input  type="submit" value="提交"/> 
    </form>

  </body>
</html>
