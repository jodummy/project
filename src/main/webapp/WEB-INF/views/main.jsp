<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!DOCTYPE html>
<html>
<head>
<title>main</title>
</head>
<body>
	<table width="400" boder="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2">
				<jsp:include page="./top.jsp" flush="false" />
			</td>
		</tr>
		<tr>
			<td width="700">
			<jsp:include page="./side.jsp" flush="false" /> 
			</td>
			<td width="300">
				여기 화면 하는 곳 
				<br><br><br>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<jsp:include page="./bottom.jsp" flush="false" />
			</td>
		</tr>
	</table>
</body>
</html>