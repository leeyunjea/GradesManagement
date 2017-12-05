<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/enrollment.css">
</head>
<body>
<h3>수강신청</h3>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/createEnrollment"
		modelAttribute="offer">

		<table>
			<tr>
				<td class="label">수강년도 :</td>
				<td><sf:select class="select" path="take_year">
						<sf:option value="2018">2018</sf:option>
				</sf:select></td>
			</tr>
			<tr>
				<td class="label">학기 :</td>
				<td><sf:select class="select" path="semester">
						<sf:option value="1">1</sf:option>
				</sf:select></td>
			</tr>
			<tr>
				<td class="label">과목코드 :</td>
				<td><sf:input type="text" path="code"/><br> 
				<sf:errors class="error" path="code"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">과목명 :</td>
				<td><sf:input path="courseName" type="text" /><br> <sf:errors class="error" path="courseName"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">구분 :</td>
				<td><sf:select class="select" path="divide">
						<sf:option value="교필">교필</sf:option>
						<sf:option value="핵교A">핵교A</sf:option>
						<sf:option value="핵교B">핵교B</sf:option>
						<sf:option value="핵교B">토대</sf:option>
						<sf:option value="핵교B">인재</sf:option>
						<sf:option value="일교">자율</sf:option>
						<sf:option value="전선">전선</sf:option>
						<sf:option value="전기">전기</sf:option>
						<sf:option value="전지">전지</sf:option>
					</sf:select></td>
			</tr>
			<tr>
				<td class="label">학점 :</td>
				<td><sf:select class="select" path="credit">
						<sf:option value="1">1</sf:option>
						<sf:option value="2">2</sf:option>
						<sf:option value="3">3</sf:option>
					</sf:select></td>
			</tr>
		</table>
		<input value="수강신청" type="submit"/>

	</sf:form>

</body>
</html>