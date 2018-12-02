<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pol�tico</title>
</head>
<body>

	<form action="cadastrar" method="post">
	
		Nome: <input type="text" name="nome" value="${values['nome']}" /><br/>
		Sobrenome: <input type="text" name="sobrenome" value="${values['sobrenome']}" /><br/>
		Apelido: <input type="text" name="apelido" value="${values['apelido']}" /><br/>
		E-mail: <input type="text" name="email" value="${values['email']}" /><br/>
		CPF: <input type="text" name="cpf" value="${values['cpf']}" /><br/>
		Data de Nascimento: <input type="text" name="dataNascimento" value="${values['dataNascimento']}" /><br/>
		Cargo(int): <input type="text" name="cargo" value="${values['cargo']}"/><br/>
		Partido(int): <input type="text" name="partido" value="${values['partido']}" /><br/>
		Org�o(int): <input type="text" name="orgao" value="${values['orgao']}" /><br/>
		Estado(int): <input type="text" name="estado" value="${values['estado']}" /><br/>
		Inscri��o Eleitoral: <input type="text" name="inscricaoEleitoral" value="${values['inscricaoEleitoral']}" /><br/>
		Forma��o Acad�mica: <input type="text" name="formacaoAcademica" value="${values['formacaoAcademica']}" /><br/>
		Data de Forma��o: <input type="text" name="dataFormacaoAcademica" value="${values['dataFormacaoAcademica']}" /><br/>
		Institui��o de Forma��o: <input type="text" name="instituicaoAcademica" value="${values['instituicaoAcademica']}" /><br/>
		<input type="submit" value="Cadastrar"/>		
	
	</form>

	<font color = "red">${erro}</font>
</body>
</html>