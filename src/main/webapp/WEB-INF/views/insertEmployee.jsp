<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>사원 추가</title>
</head>
<script type="text/javascript">
	function succesInsert() {
		var goodsForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "insertEmployeePage.do",
			data : goodsForm,
			success : function(msg) {
				alert(opener.location.href);
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
	<form id="ff" action="insertEmployeePage.do" method="post">
		<table class="table table-bordered table-hover">
		<input type="hidden" value="${storeCode}" name='storeCode'>
			<tr>
				<td>사원 이름</td>
				<td><input type="text" name="manager" id="manager" required="required"></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="phone" id="phone" required="required"></td>
			</tr>
			<tr>
				<td>파트 타임</td>
				<td><input type="text" name="seqTime" id = "seqTime" required="required"></td>
			</tr>
			<tr>
				<td align="center" colspan="3">
				<input type="button" value="사원 추가" onclick="succesInsert()"> 
				<input type="reset" value="다시쓰기"></td>
			</tr>
		</table>
	</form>
</body>



</html>