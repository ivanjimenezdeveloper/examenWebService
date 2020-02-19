<%@page import="model.entidad.Usuario"%>
<%@page import="model.entidad.Estadisticas"%>
<%@page import="model.ejb.AccidenteClienteEJB"%>
<%@page import="model.entidad.Tipos"%>
<%@page import="model.entidad.Accidente"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="org.slf4j.LoggerFactory"%>
<%@ page import="ch.qos.logback.classic.Logger"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Examen JSP</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imcDark.css" />

<%
	//recupero la sesion y el atributo de accidentes
	HttpSession sesionM = request.getSession(true);

	Usuario u = (Usuario) sesionM.getAttribute("user");
	if(u == null){
		response.sendRedirect("MainCliente");
		return;
	}
	ArrayList<Accidente> arrJ = (ArrayList) sesionM.getAttribute("accidentes");
%>



</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>Examen JSP</h1>
			<div class="nodoInvisibleHeader"></div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='MainCliente'>HOME</a></li>
			</ul>
		</div>
	</div>
	<div class="container">

		<table>
			<thead>
				<tr>
					<th>Distrito</th>
					<th>Hora</th>
					<th>Expediente</th>
					<th>Distrito</th>

				</tr>
			</thead>
			<tbody>
				<%
					//muestro cada accidente es una tabla
					if (arrJ != null | !arrJ.isEmpty()) {
						for (Accidente j : arrJ) {
							out.print("<tr>");
							out.print("<td>" + j.getFecha() + "</td>");
							out.print("<td>" + j.getHora() + "</td>");
							out.print(
									"<td><a href='ModificarAccidente?id=" + j.getId() + "'>" + j.getExpediente() + "</a></td>");
							out.print("<td>" + j.getId_distrito() + "</td>");
							out.print("<td><a href='Eliminar?id="+j.getId()+"'>ELIMINAR</td>");
							out.print("</tr>");
						}
					}
				%>
			</tbody>
		</table>

	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>