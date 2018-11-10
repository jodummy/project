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


		function deleteStore() {
			var checkboxValues = [];
			$("input[name='chkbox']:checked").each(function(i) {
				checkboxValues.push($(this).val());
			});

			var allData = {
				"storecode" : $(":checkbox[name='chkbox']:checked").val(),
				"checkArray" : checkboxValues
			};

			$.ajax({
				url : "deleteStorePage.do",
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
		function insertStore() {
			window
					.open("./insertStore.do", "선택",
							"scrollbars=yes,toolbar=yes,resizable=yes,width=450,height=500,right=150,top=0");
		}

	// 	function detailStore(storecode) {
	// 		window
	// 				.open("./detailStore.do?&storecode=" + storecode, "선택",
	// 						"scrollbars=yes,toolbar=yes,resizable=yes,width=800,height=500,right=600,top=0");
	// 	}
</script>
<body>
	<div class="col-sm-10 text-left">
		<div class="col-sm-12">
			<div style="padding-left: 50px;">
				<h2 id="txttitle">현재 상점</h2>
				<form action="deleteStorePage.do" method="post" id="ff">
					<table>
						<thead>
							<tr>
								<th><input id="allCheck" type="checkbox"
									onclick="allChk(this);" /></th>
								<th>상점 번호</th>
								<th>위치</th>
								<th>번호</th>
								<th>오늘 매출</th>
							</tr>
						</thead>
						<c:forEach items="${list }" var="list">
							<tr>
								<th><input name="chkbox" type="checkbox" id="chkList"
									value="${list.storecode }" required="required" /></th>
								<th>${list.storecode }</th>
								<th>${list.location }</th>
								<th>${list.tel }</th>
								<th>${list.income }</th>
								<th><input type="button" value="상품 상세"
									onclick="detailStore(${list.storecode })"></th>
							</tr>
						</c:forEach>
					</table>
					<input type="button" value="상점 추가" onclick="insertStore()">
					<input type="button" value="상점 제거" onclick="deleteStore()">
				</form>

			</div>
		</div>
	</div>
</body>
</html>