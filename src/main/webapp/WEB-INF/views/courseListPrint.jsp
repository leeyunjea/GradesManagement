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
	<h3>교과목 리스트</h3>
	<table>
		<thead>
			<th>수강년도</th>
			<th>학기</th>
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</thead>
		<c:forEach var="offer" items="${courseListPrints}">
			<tr>
				<td>${offer.take_year}</td>
				<td>${offer.semester}</td>
				<td>${offer.code}</td>
				<td>${offer.courseName}</td>
				<td>${offer.divide}</td>
				<td>${offer.credit}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a id="enrollment_a" href="${pageContext.request.contextPath}">메뉴로 돌아가기</a>
</body>
</html>