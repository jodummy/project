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
<title>상품 추가</title>
</head>
<script type="text/javascript">
	function succesInsert(storeCode) {
		var goodsForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "insertGoodsPage.do",
			data : goodsForm,
			success : function(msg) {
				alert(opener.location.href);
				opener.location.href = "goods.do?&storeCode=" + storeCode;
				window.close();
			},
			error : function(textStatus, errorThrown) {
				alert("중복 문제");
			}
		});
	}
</script>

<body>
	<form id="ff" action="insertGoodsPage.do" method="post">
		<table class="table table-bordered table-hover">
		<input type="hidden" value="${storeCode}" name='storeCode'>
			<tr>
				<td>goodsNumber</td>
				<td><input type="text" name="goodsNumber" id="goodsNumber" required="required"></td>
			</tr>
			<tr>
				<td>goodsName</td>
				<td><input type="text" name="goodsName" id="goodsName" required="required">
				 <input type="button" onclick="validityCheck()" value="중복체크"></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" required="required"></td>
			</tr>
			<tr>
				<td align="center" colspan="3"><input type="button"
					value="상품 추가" onclick="succesInsert('${storeCode}')"> 
					<input type="reset" value="다시쓰기"></td>
			</tr>
		</table>
	</form>
</body>



</html>