<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='stylesheet' type='text/css' href='imcDark.css' />

</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>Gestion de accidentes</h1>
			<div class="nodoInvisibleHeader"></div>
			<div class="usuario">
				<div>
					<p class="nombreUsuario">Usuario</p>
				</div>

			</div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='MainCliente'>HOME</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<form method="POST" action="MainCliente">
			<div>
				<p>Usuario</p>
				<input type="text" name="user" />
			</div>
			<div>
				<p>Contraseña</p>
				<input type="password" name="pass" />
			</div>
			<input type="submit" value="Log In" />
		</form>
	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>