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

	function deleteEmployee() {

		var checkboxValues = [];
		$("input[name='chkbox']:checked").each(function(i) {
			checkboxValues.push($(this).val());
		});

		var allData = {
			"phone" : $(":checkbox[name='chkbox']:checked").val(),
			"checkArray" : checkboxValues
		};

		$.ajax({
			url : "deleteEmployeePage.do",
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
	
	function modifyStore(storeCode) {
		window.open(
						"./modifyStore.do?&storeCode=" + storeCode,
						"선택",
						"scrollbars=yes,toolbar=yes,resizable=yes,width=1000,height=600,right=700,top=0");
	}
	
	function insertEmployee(storeCode) {
		window.open(
						"./insertEmployee.do?&storeCode=" + storeCode,
						"선택",
						"scrollbars=yes,toolbar=yes,resizable=yes,width=1000,height=600,right=700,top=0");
	}
	

	
</script>
<body>
	<h1>상점</h1>
	<table>
		<tr>
			<td>위치</td>
			<td>${dto.location}</td>
		</tr>
		<tr>
			<td>tel</td>
			<td>${dto.tel}</td>
		</tr>
		<tr>
			<td>수입</td>
			<td>${dto.inCome}</td>
		</tr>
	</table>
	<form action="./store.do" method="post" id="ff">
		<input type="hidden" value="${dto.storeCode}" name='storeCode'>
		<div colspan="3">
			<input type="button" value="수정" onclick="modifyStore('${dto.storeCode}')">
		</div>
	</form>



	<h2 id="txttitle">직원</h2>
	<form action="deleteEmployeePage.do" method="post" id="ff">
		<table>
			<thead>
				<tr>
					<th><input id="allCheck" type="checkbox" onclick="allChk(this);" /></th>
					<th>이름</th>
					<th>번호</th>
					<th>순서</th>
				</tr>
			</thead>
			<c:forEach items="${dto2 }" var="dto2">
				<tr>
					<th><input name="chkbox" type="checkbox" id="chkList" value="${dto2.phone }" required="required" /></th>
					<th>${dto2.manager }</th>
					<th>${dto2.phone }</th>
					<th>${dto2.seqTime }</th>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="사람 추가" onclick="insertEmployee('${dto.storeCode}')">
		<input type="button" value="사람 제거" onclick="deleteEmployee()">
	</form>
</body>
</html>