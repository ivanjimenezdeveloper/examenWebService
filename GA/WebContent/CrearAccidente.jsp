<%@page import="model.entidad.Distritos"%>
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
	HttpSession sesionM = request.getSession(true);
	ArrayList<Tipos> arrJ = (ArrayList) sesionM.getAttribute("tipos");
	ArrayList<Distritos> arrD = (ArrayList) sesionM.getAttribute("distritos");

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
				<li><a href='Main'>HOME</a></li>
			</ul>
		</div>
	</div>
	<div class="container">

		<form>
			<label>Expediente</label> <input type="number" name="expediente">
			<label>Fecha</label> <input type="date" name="fecha"> <label>Hora</label>
			<input type="number" name="hora"> <label>Minuto</label> <input
				type="number" name="minuto"> <label>Direccion</label> <input
				type="text" name="direccion"> 
				<label>Distrito</label>
				 <select name="distrito">
				<%
					if (arrD != null | !arrD.isEmpty()) {
						for (Distritos j : arrD) {
							out.print("<option value='" + j.getId() + "'>" + j.getNombre() + "</option>");

						}
					}
				%>
				 </select> <label>Tipo Accidente</label> <select
				name="accidenteTipo">
				<%
					if (arrJ != null | !arrJ.isEmpty()) {
						for (Tipos j : arrJ) {
							out.print("<option value='" + j.getId() + "'>" + j.getNombre() + "</option>");

						}
					}
				%>
			</select> <label>Tipo Vehiculo</label> <select name="vehiculoTipo"></select> <label>Sexo</label>
			<select name="sexo"></select> <input type="submit" value="Registrar">
		</form>
		<%
			// 								if (arrJ != null | !arrJ.isEmpty()) {
			// 									for (Accidente j : arrJ) {
			// 										out.print("<tr>");
			// 										out.print("<td>" + j.getFecha() + "</td>");
			// 										out.print("<td>" + j.getExpediente() + "</td>");
			// 										out.print("<td>" + j.getId_distrito() + "</td>");

			// 										out.print("</tr>");
			// 									}
			// 								}
		%>


	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>