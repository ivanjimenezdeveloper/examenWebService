<%@page import="model.entidad.Estadisticas"%>
<%@page import="model.entidad.Distritos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>HOME</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imcDark.css" />
<%
	HttpSession sesionM = request.getSession(true);
	ArrayList<Distritos> arrJ = (ArrayList) sesionM.getAttribute("distritos");
%>
</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>Seguridad Vial</h1>
			<div class="nodoInvisibleHeader"></div>
			<div class="usuario">
				<div>
					<p class="nombreUsuario">Usuario</p>
				</div>
			</div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='Main'>HOME</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<form action="Main" method="post">
			<label>Inicio</label> <input type="date" name="inicio" /> <br>
			<label>Fin</label> <input type="date" name="fin" /> 
				<select name="distrito">
				<%
					if (arrJ != null | !arrJ.isEmpty()) {
						for (Distritos j : arrJ) {

							out.print("<option value='"+j.getId()+"'>"+j.getNombre()+"</option>");
						}
					}
				%>
			</select>
			<input
				type="submit" value="Muestra">
		</form>
	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>