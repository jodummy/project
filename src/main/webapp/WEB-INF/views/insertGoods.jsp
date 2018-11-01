<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form id="ff" action="insertGoodsPage.do" method="post">
		<table class="table table-bordered table-hover">
			<tr>
				<td>goodsnumber</td>
				<td><input type="text" name="goodsnumber" id="goodsnumber"
					required="required"> <input type="button"
					onclick="validityCheck()" value="중복체크"></td>
			</tr>
			<tr>
				<td>goodsname</td>
				<td><input type="text" name="goodsname" id="goodsname"
					required="required"> <input type="button"
					onclick="validityCheck()" value="중복체크"></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" required="required"></td>
			</tr>
			<tr>
				<td align="center" colspan="3"><input type="button" value="글입력"
					onclick="succesInsert()"> <input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>

<script type="text/javascript">
	// 	alert('실행');
	// 	function validityCheck() {
	// 		$.ajax({
	// 			type : "post",
	// 			url : "./validityCheck.do",
	// 			data : {
	// 				"mem_email" : $("#mem_email").val()
	// 			},
	// 			success : function(msg) {
	// 				if (msg.isc) {
	// 					alert("써라");
	// 				} else {
	// 					alert("쓰지마.");
	// 				}
	// 			},
	// 			error : function() {
	// 				alert("ajax 실패");
	// 			}
	// 		});
	// 	}

	function succesInsert() {
		var goodsForm = $("#ff").serialize();
		$.ajax({
			type : "post",
			url : "insertGoodsPage.do",
			data : goodsForm,
			success : function(msg) {
					alert("등록 완료");
					opener.location.href = "goods.do";
					window.close();
			},
			error : function(textStatus, errorThrown) {
				alert("중복 문제");
			}
		});
	}
</script>

</html>