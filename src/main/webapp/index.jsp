<%--
  ~ 版权所有.(c)2008-2017. 卡尔科技工作室
  --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Hello World! <jsp:include page="logout_include.jsp"></jsp:include></h2>
当前用户：
<shiro:principal></shiro:principal>
</body>
</html>
