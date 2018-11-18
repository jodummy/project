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
</head>
<script type="text/javascript">
	//1.모두 체크
	function allChk(obj) {
		var chkObj = document.getElementsByName("chkbox");
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

	

	function deleteGoods() {
		var checkboxValues = [];
		$("input[name='chkbox']:checked").each(function(i) {
			checkboxValues.push($(this).val());
		});

		var allData = {
			"goodsnumber" :$(":checkbox[name='chkbox']:checked").val(),
			"checkArray" : checkboxValues,
			"storeCode" : $('input[name=storeCode]').val()
		};

		$.ajax({
			url : "deleteGoodsPage.do",
			type : 'GET',
			data : allData,
			success : function(data) {
				location.reload();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				if(errorThrown == 'Bad Request')
					alert('번호를 눌러주세요');
				else
					alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
			}
		});

	}

	//insert
	function insertGoods(storeCode) {
		window.open("./insertGoods.do?&storeCode=" + storeCode, "선택",
						"scrollbars=yes,toolbar=yes,resizable=yes,width=450,height=500,right=150,top=0");
	}
	
	function detailGoods(goodsNumber) {
		window.open("./detailGoods.do?&goodsNumber=" + goodsNumber, "선택",
				"scrollbars=yes,toolbar=yes,resizable=yes,width=800,height=500,right=600,top=0");
	}
</script>

<body>
	<div class="col-sm-10 text-left">
		<div class="col-sm-12">
			<div style="padding-left: 50px;">
				<h2 id="txttitle">현재 상품</h2>
				<form action="deleteGoodsPage.do" method="post" id="ff">
					<input type="hidden" name="storeCode" value="${storeCode}">
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
								<th><input name="chkbox" type="checkbox" id="chkList"
									value="${list.goodsNumber }" required="required" /></th>
								<th>${list.goodsNumber }</th>
								<th>${list.goodsName }</th>
								<th>${list.price }</th>
								<th>${list.nowStock }</th>
								<th>${list.inputGoods }</th>
								<th>${list.outputGoods }</th>
								<th>${list.soldNum }</th>
								<th>${list.newItem }</th>
								<th><input type="button" value="상품 상세"
									onclick="detailGoods(${list.goodsNumber })"></th>
							</tr>
						</c:forEach>
					</table>
					<input type="button" value="상품 추가" onclick="insertGoods('${storeCode}')">
					<input type="button" value="상품 제거" onclick="deleteGoods()">
				</form>

			</div>
		</div>
	</div>
</body>
</html>