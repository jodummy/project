<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 이건 스타일이야 건들지말고 -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>modifyGoods</title>
</head>
<script type="text/javascript">
	function succesUpdate() {
		var goodsForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "modifyGoodspage.do",
			data : goodsForm,
			success : function(msg) {
				alert(opener.location.href);
				opener.location.href = "goods.do";
				window.close();
			},
			error : function(textStatus, errorThrown) {
				alert("실패");
			}
		});
	}

	$(function() {
		$("#inputgoods").datepicker();
	});
	$(function() {
		$("#outputgoods").datepicker();
	});
</script>
<body>
	<form action="modifyGoodspage.do" method="post" id="ff">
		<input type="hidden" name="storeCode" value="${dto.storeCode}">
		<input type="hidden" name="goodsNumber" value="${dto.goodsNumber}">
		<table class="table table-bordered table-hover">
			<tr>
				<td>상품 이름</td>
				<td><input type="text" value="${dto.goodsName}"
					name="goodsname"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" value="${dto.price}" name="price"></td>
			</tr>
			<tr>
				<td>현재 재고</td>
				<td><input type="text" value="${dto.nowStock}" name="nowStock"></td>
			</tr>

			<tr>
				<td>팔린 갯수</td>
				<td><input type="text" value="${dto.soldNum}" name="soldNum"></td>
			</tr>
			<tr>
				<td>출입 날짜</td>
				<td><input type="text" id="inputGoods" name="inputGoods"
					value="${dto.inputGoods}"></td>
			</tr>
			<tr>
				<td>유통기한</td>
				<td><input type="text" id="outputGoods" name="outputGoods"
					value="${dto.outputGoods}"></td>
			</tr>
			<tr>
				<td>칼로리</td>
				<td><input type="text" value="${dto.calorie}" name="calorie"></td>

			</tr>
			<tr>
				<td>상품 정보</td>
				<td><textarea name="goodsInfo" rows="10" cols="100"
						value="${dto.goodsInfo}"></textarea></td>
			</tr>
			<tr>

				<td align="center" colspan="3"><input type="button"
					value="수정이 완료" onclick="succesUpdate()" class="btn btn-default">
					<input type="reset" value="다시쓰기" class="btn btn-default"></td>
			</tr>

		</table>
	</form>

</body>

</html>