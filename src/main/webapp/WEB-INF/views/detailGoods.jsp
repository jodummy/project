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
	function modifyGoods(goodsNumber ,storeCode ) {
		window.open("./modifyGoods.do?&goodsNumber=" + goodsNumber + '&storeCode=' + storeCode,"선택","scrollbars=yes,toolbar=yes,resizable=yes,width=1000,height=600,right=700,top=0");
	}
</script>
<body>
	<table>
		<tr>
			<td>상품 이름</td>
			<td>${dto.goodsName}</td>
		</tr>
		<tr>
			<td>상품 가격</td>
			<td>${dto.price}</td>
		</tr>
		<tr>
			<td>현재 재고</td>
			<td>${dto.nowStock}</td>
		</tr>
		<tr>
			<td>출입 날짜</td>
			<td>${dto.inputGoods}</td>
		</tr>
		<tr>
			<td>유통 기한</td>
			<td>${dto.outputGoods}</td>
		</tr>
		<tr>
			<td>팔린 현황</td>
			<td>${dto.soldNum}</td>
		</tr>
		<tr>
			<td>신상</td>
			<td>${dto.newItem}</td>
		</tr>
		<tr>
			<td>칼로리</td>
			<td>${dto.calorie}</td>
		</tr>
		<tr>
			<td>인기 순위</td>
			<td>${dto.rankGoods}</td>
		</tr>
		<tr>
			<td>상품 정보</td>
			<td>${dto.goodsInfo}</td>
		</tr>
	</table>
	<form action="./goods.do" method="post" id="ff">
		<input type="hidden" value="${dto.goodsNumber}" name='goodsNumber'>
		<input type="hidden" value="${storeCode}" name='storeCode'>
		<div colspan="3">
			<input type="button" value="수정"
				onclick="modifyGoods('${dto.goodsNumber}' , '${storeCode}')" class="btn btn-default">
		</div>
	</form>

</body>


</html>