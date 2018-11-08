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
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function succesInsert() {
		var goodsForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "./modifyGoodspage.do",
			data : goodsForm,
			success : function(msg) {
				opener.location.href = "./goods.do";
				window.close();
			},
			error : function(textStatus, errorThrown) {
				alert("실패");
			}
		});
	}
</script>
<body>
	<form action="./modyGoodsPage.do" method="post" id="ff">
		<input type="hidden" name="" value="${dto.goodsnumber}">
		<table class="table table-bordered table-hover">
			<tr>
				<td>상품 이름</td>
				<td><input type="text" value="${dto.goodsname}"
					name="goodsname"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" value="${dto.price}" name="price"></td>
			</tr>
			<tr>
				<td>현재 재고</td>
				<td><input type="text" value="${dto.nowstock}" name="nowstock"></td>
			</tr>

			<tr>
				<td>팔린 갯수</td>
				<td><input type="text" value="${dto.soldnum}" name="soldnum"></td>
			</tr>
			<tr>
				<td>출입 날짜</td>
				<td><input type="date" id="doc_InputDate" name="inputgoods"
					value="${dto.inputgoods}"></td>
			</tr>
			<tr>
				<td>유통기한</td>
				<td><input type="date" id="doc_OutDate" name="expirationdate"
					value="${dto.expirationdate}"></td>
			</tr>
			<tr>
				<td>칼로리</td>
				<td><input type="text" value="${dto.calorie}" name="calorie"></td>

			</tr>
			<tr>
				<td>상품 정보</td>
				<td><textarea name="goodsinfo" rows="10" cols="100"
						value="${dto.goodsinfo}"></textarea></td>
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