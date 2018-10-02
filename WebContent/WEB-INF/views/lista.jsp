<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
		</tr>
		<c:forEach items="${lista}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>