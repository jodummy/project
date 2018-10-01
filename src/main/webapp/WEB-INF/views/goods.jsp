<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>


<title>상품</title>
</head>
<style type="text/css">
</style>

<script type="text/javascript">
	//1.모두 체크
	function allChk(obj) {
		var chkObj = document.getElementsByName("RowCheck");
		var rowCnt = chkObj.length - 1;
		var check = obj.checked;
		if (check) {
			for (var i = 0; i <= rowCnt; i++) {
				if (chkObj[i].type == "checkbox")
					chkObj[i].checked = true;
			}
		} else {
			for (var i = 0; i <= rowCnt; i++) {
				if (chkObj[i].type == "checkbox") {
					chkObj[i].checked = false;
				}
			}
		}
	}
</script>
<body>
	<form action="#" method="post" id='frmPaging' name="frmPaging">
		<table>
			<thead>
				<tr>
					<th><input id="allCheck" type="checkbox"
						onclick="allChk(this);" /></th>
					<th>상품 번호</th>
					<th>상품 이름</th>
					<th>가격</th>
					<th>재고</th>
					<th>들어온 날짜</th>
					<th>유통기간</th>
					<th>팔린 갯수</th>
					<th>신상</th>
				</tr>
			</thead>
			<c:forEach items="${list }" var="list">
				<tr>
					<th><input ﻿ name="RowCheck" type="checkbox"
						value="${list.goodsnumber}" /></th>
					<th>${list.goodsnumber }</th>
					<th>${list.goodsname }</th>
					<th>${list.price }</th>
					<th>${list.nowstock }</th>
					<th>${list.inputgoods }</th>
					<th>${list.expirationdate }</th>
					<th>${list.soldnum }</th>
					<th>${list.newitem }</th>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>