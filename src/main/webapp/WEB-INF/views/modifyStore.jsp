
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyStore</title>
</head>
<script type="text/javascript">
	function succesInsert() {
		var storeForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "./modyStorePage.do",
			data : storeForm,
			success : function(msg) {
				opener.location.href = "./store.do";
				window.close();
			},
			error : function(textStatus, errorThrown) {
				alert("실패");
			}
		});
	}
</script>
<body>

	<form action="./modyStorePage.do" method="post" id="ff">
		<input type="hidden" name="storecode" value="${dto.storecode}">
		<table class="table table-bordered table-hover">
			<tr>
				<td>위치</td>
				<td><input type="text" value="${dto.location}" name="location"></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" value="${dto.tel}" name="tel"></td>
			</tr>
			<tr>
				<td>수입</td>
				<td><input type="text" value="${dto.income}" name="income"></td>
			</tr>
			<tr>
				<td align="center" colspan="3"><input type="button"
					value="수정이 완료" onclick="succesInsert()" class="btn btn-default">
					<input type="reset" value="다시쓰기" class="btn btn-default"></td>
			</tr>
		</table>
	</form>


</body>
</html>