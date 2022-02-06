<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div class="header">
		<div class="container-fluid" id="nav-itens">
			<a>
				<h3>Raia Drogasil</h3>
			</a>
			<div>
				<ul>
					<a>Usuario</a>
				</ul>
			</div>
		</div>

		<div id="cabecalho-pagina">
			<h1>Lista de usuario</h1>
		</div>

		<div class="container" id="btn-cadastrar">
			<hr>
			<a href="cadastro.jsp"  button  class="btn btn-primary" type="submit">Adicionar
				Usuario</a>
		</div>

		<div class="container" id="table">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Email</th>
						<th scope="col">Pais</th>
						<th scope="col">Acões</th>
					</tr>
				</thead>
				
				<!-- Lista usuarios cadastrados -->
				<c:forEach items="${usuarios}" var="user" varStatus="i">

					<tr>
						<td>${user.id}</td>
						<td>${user.nome}</td>
						<td>${user.email}</td>
						<td>${user.pais}</td>
						<td><a href="?id=${i.index}&alterar=1">Alterar</a></td>
						<td><a href="?id=${i.index}&alterar=0">Remover</a></td>
					</tr>
					
				</c:forEach>

			</table>
		</div>
	</div>
</body>

</html>