<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
	<p>Bem Vindo ${logged.nome}!</p>
	<form action="adicionausuario">
		Nome: 	
		<input type="text" name="nome" /><br />
		E-mail: 
		<input type="text" name="email" /><br />
		<input type="submit" value="Gravar" />
		<form:errors path="user.nome" cssStyle="color:red"/>
	</form>
	
	<form action = "retrieveuser">
		Nome:
		<input type ="text" name="nome" />
		<input type="submit" value="Pesquisar"/>
	</form>
	
	<form action = "retrieveuser">
		<br/>
		<input type="submit" value="Pesquisar Todos"/>
	</form>
	<a href="logout">Logout</a>
</body>
</html>