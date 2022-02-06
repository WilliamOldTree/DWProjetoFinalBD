<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<a href="">
				<h3>Raia Drogasil</h3>
			</a>
			<div>
				<ul>
					<a href="">Usuario</a>
				</ul>
			</div>
		</div>

		<div class="container" id="cont-input">

			<div class="label-input">



				<form method="post" action="Controller">

					<h1>Adicionar usuario</h1>
					<input type="hidden" name="id" value=${id }>

					<div class="mb-3">
						<label for="exampleInputNome1" class="form-label">Nome</label> <input
							type="text" class="form-control" name="nome" value=${nome }>
					</div>

					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email</label> <input
							type="email" class="form-control" name="email" value=${email }>
					</div>

					<div class="mb-3">
						<label for="exampleInputPais" class="form-label">Pais</label> <input
							type="text" class="form-control" name="pais" value=${pais }>
					</div>

					<div>
						<input  type="submit" class="btn btn-primary"  value="Salvar">
					</div>

				</form>
			</div>

		</div>





	</div>
</body>

</html>