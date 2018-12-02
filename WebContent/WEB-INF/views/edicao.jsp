<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="finalizarEdicao" method="post">
		<input type = "hidden" name = "id" value="${p.id}">
		Nome: <input type="text" name="nome" value="${p.nome}" /><br/>
		Sobrenome: <input type="text" name="sobrenome" value="${p.sobrenome}" /><br/>
		Apelido: <input type="text" name="apelido" value="${p.apelido}" /><br/>
		E-mail: <input type="text" name="email" value="${p.email}" /><br/>
		CPF: <input type="text" name="cpf" value="${p.cpf}" /><br/>
		Data de Nascimento: <input type="text" name="dataNascimento" value="${p.dataNascimento}" /><br/>
		Cargo(int): <input type="text" name="cargo" value="${p.cargo}"/><br/>
		Partido(int): <input type="text" name="partido" value="${p.partido}" /><br/>
		Orgão(int): <input type="text" name="orgao" value="${p.orgao}" /><br/>
		Estado(int): <input type="text" name="estado" value="${p.estado}" /><br/>
		Inscrição Eleitoral: <input type="text" name="inscricaoEleitoral" value="${p.inscricaoEleitoral}" /><br/>
		Formação Acadêmica: <input type="text" name="formacaoAcademica" value="${p.formacaoAcademica}" /><br/>
		Data de Formação: <input type="text" name="dataFormacaoAcademica" value="${p.dataFormacaoAcademica}" /><br/>
		Instituição de Formação: <input type="text" name="instituicaoAcademica" value="${p.instituicaoAcademica}" /><br/>
		<input type="submit" value="Editar"/>		
		
	</form>

	<font color = "red">${erro}</font>
</body>
</html>