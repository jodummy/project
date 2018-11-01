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
</head>
<style type="text/css">
.projectIcon {
	width: 50px;
	height: 50px;
}

.board_title {
	text-align: left;
}

#boardTable, th {
	text-align: center;
}

#keyWordTextBox {
	border: 1px solid #b3b3b3;
}

.center {
	text-align: center;
}

.pageArrow {
	width: 67px;
}

.pageBlank {
	
}

.pageNumbers {
	text-align: center;
	width: 200px;
}
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

	function insertGoode() {
		window
				.open("./insertGoods.do", "선택",
						"scrollbars=yes,toolbar=yes,resizable=yes,width=450,height=500,right=150,top=0");
	}

	function deleteGoode() {

	}
</script>

<body>
	<div class="col-sm-10 text-left">
		<div class="col-sm-12">
			<div style="padding-left: 50px;">
				<h2 id="txttitle">현재 상품</h2>


				<div style="padding-left: 50px;">
					<h2 id="txttitle">팀원 리스트</h2>
					<hr>
					<!-- 한번에 출력할 목록 갯수 -->
					<div align="right" style="padding: 0px 10px 10px 0px;">
						<select class='btn btn-primary' id='listCount' name='listCount'
							onchange='listCnt();'>
							<option value='5'>5</option>
							<option value='10'>10</option>
							<option value='15'>15</option>
							<option value='20'>20</option>
						</select>
					</div>



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
						<!-- 여기에 넣어주면 되요 paging -->


					</form>
					<input type="button" value="상품 추가" onclick="insertGoode()">
					<input type="button" value="상품 제거" onclick="deleteGoode()">
				</div>
			</div>
		</div>
</body>
</html>