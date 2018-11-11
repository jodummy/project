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
<title>상점 추가</title>
</head>
<script type="text/javascript">
	function succesInsert() {
		var goodsForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "insertStorePage.do",
			data : goodsForm,
			success : function(msg) {
				opener.location.href = "store.do";
				window.close();
			},
			error : function(textStatus, errorThrown) {
				alert("중복 문제");
			}
		});
	}
</script>
<body>
	<form id="ff" action="insertStorePage.do" method="post">
		<table class="table table-bordered table-hover">
			<tr>
				<td>storecode</td>
				<td><input type="text" name="storecode" id="storecode"
					required="required"></td>
			</tr>
			<tr>
				<td>location</td>
				<td><input type="text" name="location" id="location"
					required="required"></td>
			</tr>
			<tr>
				<td>tel</td>
				<td><input type="text" name="tel" id="tel" required="required"></td>
			</tr>
			<tr>
				<td align="center" colspan="3"><input type="button"
					value="상점 추가" onclick="succesInsert()"> <input type="reset"
					value="다시쓰기"></td>
			</tr>
		</table>
	</form>
</body>

</html>