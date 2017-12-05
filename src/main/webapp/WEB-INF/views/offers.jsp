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
	<h3>학년/학기별 이수학점</h3>
	<table>
		<thead>
			<th>년도</th>
			<th>학기</th>
			<th>이수 학점</th>
			<th>상세보기</th>
		</thead>
		<c:forEach var="offer" items="${offers}">
			<tr>
				<td><c:out value="${offer.take_year}"></c:out></td>
				<td><c:out value="${offer.semester}"></c:out></td>
				<td><c:out value="${offer.credit}"></c:out></td>
				<td><a
					href="${pageContext.request.contextPath}/courseListbySemester?take_year=${offer.take_year}&semester=${offer.semester}">링크
						
				</a></td>
			</tr>
		</c:forEach>
		<%-- <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> --%>
	</table>
	
</body>
</html>