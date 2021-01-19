<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisEmployee</title>
</head>
<body>
	<h3>員工資料</h3>
	<p>員工編號: ${employee_basic.employee_id}</p>
	<p>姓名: ${employee_basic.employee_name}</p>
	<p>部門: ${employee_basic.employee_department}</p>
	<p>職位: ${employee_basic.employee_position}</p>
<%-- 	<P>: ${}</P> --%>
<%-- 	<P>: ${}</P> --%>
<%-- 	<P>: ${}</P> --%>
<%-- 	<P>: ${}</P> --%>
<%-- 	<P>: ${}</P> --%>
<%-- 	<P>: ${}</P> --%>
</body>
</html>