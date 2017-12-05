<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<h3>이수 구분별 학점 내역</h3>
	<table>
		<thead>
			<c:forEach var="offer" items="${creditbydivides}">
				<th>${offer.divide}</th>
			</c:forEach>
			<th>총학점</th>
		</thead>
		<tr>				
			<c:forEach var="offer" items="${creditbydivides}">
				<td>${offer.credit}</td>
			</c:forEach>
			<td>${totalCredit}</td>
		</tr>
	</table>
	
	<a id="enrollment_a" href="${pageContext.request.contextPath}">메뉴로 돌아가기</a>
</body>
</html>