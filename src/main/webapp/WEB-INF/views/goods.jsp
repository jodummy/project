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

	//값이 넘어가지 않는다. 이걸 처리해줘 controller에서 값을 받아주지 않는다

	function deleteGoode() {

		// 		if ($(":checkbox[name='chkbox']:checked").length == 0) {
		// 			alert("삭제할 항목을 하나이상 체크해주세요.");
		// 			return;
		// 		} else if ($(":checkbox[name='chkbox']:checked").length > 1) {
		// 			alert("다중 삭제.");
		// 			return;
		// 		}
		// 		alert($(":checkbox[name='chkbox']:checked").val());
		// 		// 		var allData = { "userId": userId, "checkArray": checkboxValues };
		// 		var gData = {
		// 			"userId" : userId
		// 		};
		// 		$.ajax({
		// 			type : "POST",
		// 			url : "deleteGoodsPage.do",
		// 			data : $(":checkbox[name='chkbox']:checked").val(),
		// 			success : function(msg) {
		// 				alert("완료");
		// 			},
		// 			error : function(textStatus, errorThrown) {
		// 				alert("문제");
		// 			}
		// 		});

		var checkboxValues = [];
		$("input[name='chkbox']:checked").each(function(i) {
			checkboxValues.push($(this).val());
		});

		var allData = {
			"goodsnumber" : $(":checkbox[name='chkbox']:checked").val(),
			"checkArray" : checkboxValues
		};

		$.ajax({
			url : "deleteGoodsPage.do",
			type : 'GET',
			data : allData,
			success : function(data) {
				location.reload();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
			}
		});

	}

	//insert
	function insertGoode() {
		window
				.open("./insertGoods.do", "선택",
						"scrollbars=yes,toolbar=yes,resizable=yes,width=450,height=500,right=150,top=0");
	}
</script>

<body>
	<div class="col-sm-10 text-left">
		<div class="col-sm-12">
			<div style="padding-left: 50px;">
				<h2 id="txttitle">현재 상품</h2>
				<form action="deleteGoodsPage.do" method="post" id="ff">
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
									value="${list.goodsnumber }" required="required" /></th>
								<th>${list.goodsnumber }</th>
								<th>${list.goodsname }</th>
								<th>${list.price }</th>
								<th>${list.nowstock }</th>
								<th>${list.inputgoods }</th>
								<th>${list.expirationdate }</th>
								<th>${list.soldnum }</th>
								<th>${list.newitem }</th>
								<th><input type="button" value="상품 수정"
									onclick="modifyGoode()"></th>
							</tr>
						</c:forEach>
					</table>
					<input type="button" value="상품 추가" onclick="insertGoode()">
					<input type="button" value="상품 제거" onclick="deleteGoode()">
				</form>

			</div>
		</div>
	</div>
</body>
</html>