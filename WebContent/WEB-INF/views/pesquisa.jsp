<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pesquisa</title>
</head>
<body>
	<p> Pesquise por Sobrenome ou Inscri��o Eleitoral </p> <br>
	<form action = "pesquisar" method = "get">
		Sobrenome: <input type = "text" name = "sobrenome"><br>
		Inscri��o Eleitoral: <input type = "text" name = "matricula"><br>
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
				<td><b>Inscri��o</b></td>
			</tr>
			<c:forEach items ="${valores}" var = "pol">
				<tr> 
					<td>${pol.nome}</td>
					<td>${pol.sobrenome}</td>
					<td>${pol.inscricaoEleitoral}</td>
					<td><a href = "perfil?id=${pol.id}">Ver</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test = "${not empty p}">
		<h2>${p.nome} ${p.sobrenome}</h2> 
		<b>Apelido:</b> ${p.apelido}<br/>
		<b>E-mail:</b> ${p.email}<br/>
		<b>CPF:</b> ${p.cpf}<br/>
		<b>Data de Nascimento:</b> ${p.dataNascimento}<br/>
		<b>Cargo:</b> ${p.cargo}<br/>
		<b>Partido:</b> ${p.partido}<br/>
		<b>Org�o:</b> ${p.orgao}<br/>
		<b>Estado:</b> ${p.estado}<br/>
		<b>Inscri��o Eleitoral:</b> ${p.inscricaoEleitoral}<br/>
		<b>Forma��o Acad�mica:</b> ${p.formacaoAcademica}<br/>
		<b>Data de Forma��o:</b> ${p.dataFormacaoAcademica}<br/>
		<b>Institui��o de Forma��o:</b> ${p.instituicaoAcademica}<br/>
		<button type="button" name="back" onclick="history.back()">Voltar</button>
	</c:if>
</body>
</html>