<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cadastro</title>
</head>
<body>
	<p> Pesquise por Sobrenome ou Inscrição Eleitoral </p> <br>
	<form action = "seleceditar" method = "get">
		Sobrenome: <input type = "text" name = "sobrenome"><br>
		Inscrição Eleitoral: <input type = "text" name = "matricula"><br>
		<input type = "submit" value = "Pesquisar">
	</form>
	<font color = "red">${feedback}</font>
	<br>
	<c:if test = "${not empty valores}">
		<h2>Resultados</h2> 
		<table>
			<tr>
				<td><b>Nome</b></td>
				<td><b>Sobrenome</b></td>
				<td><b>Inscrição</b></td>
			</tr>
			<c:forEach items ="${valores}" var = "p">
				<tr> 
					<td>${p.nome}</td>
					<td>${p.sobrenome}</td>
					<td>${p.inscricaoEleitoral}</td>
					<td><a href = "editar?id=${p.id}">Editar</a></td>
					<td><a href = "excluir?id=${p.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>