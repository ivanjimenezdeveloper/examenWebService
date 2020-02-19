<%@page import="model.entidad.Vehiculo"%>
<%@page import="model.entidad.Sexo"%>
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
<title>Gestion Accidentes</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imcDark.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<%
	//recupero la sesion y sus atributos

	HttpSession sesionM = request.getSession(true);
	ArrayList<Tipos> arrJ = (ArrayList) sesionM.getAttribute("tipos");
	ArrayList<Distritos> arrD = (ArrayList) sesionM.getAttribute("distritos");
	ArrayList<Sexo> arrS = (ArrayList) sesionM.getAttribute("sexos");
	ArrayList<Vehiculo> arrV = (ArrayList) sesionM.getAttribute("vehiculos");
	Accidente acc = (Accidente) sesionM.getAttribute("accidente");
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
		<script type="text/javascript">
		$(document).ready(function () {
			
			//guardo los datos del accidente a modificar en el form
			var hora = '<%out.print(acc.getHora());%>';
			
			var horaArray = hora.split(":");
			$("#hora").val(horaArray[0]);
			$("#min").val(horaArray[1]);
			$("#distrito").val("<%out.print(acc.getId_distrito());%>");
			$("#accidenteTipo").val("<%out.print(acc.getId_tipo_accidente());%>");
			$("#vehiculoTipo").val("<%out.print(acc.getId_tipo_vehiculo());%>");
			$("#sexo").val("<%out.print(acc.getId_sexo());%>");
			

					});
		</script>
	</div>
	<div class="container">

		<form action="ModificarAccidente" method="post">
			<label>Expediente</label> <input type="text" name="expediente"
				value="<%
				//Muestra el expediente
				out.print(acc.getExpediente());%>"
				required="required" id="expediente"> <label>Fecha</label> <input
				type="date" name="fecha" required="required"
				value="<%
						//Muestra la fecha

				out.print(acc.getFecha());%>"> <label>Hora</label>
			<input type="number" name="hora" id="hora" max="23" min="0"
				required="required"> <label>Minuto</label> <input
				type="number" name="minuto" id="min" max="59" min="0"
				required="required"> <label>Direccion</label> <input
				type="text" name="direccion"
				value="<%
				//Muestra la direccion
				out.print(acc.getDireccion());%>" required="required">
			<label>Distrito</label> <select name="distrito" id="distrito"
				required="required">
				<%
				//Muestra los ditritos en opciones
					if (arrD != null | !arrD.isEmpty()) {
						for (Distritos j : arrD) {
							out.print("<option value='" + j.getId() + "'>" + j.getNombre() + "</option>");

						}
					}
				%>
			</select> <label>Tipo Accidente</label> <select name="accidenteTipo"
				required="required" id="accidenteTipo">
				<%
				//Muestra los tipos de accidentes en opciones
					if (arrJ != null | !arrJ.isEmpty()) {
						for (Tipos j : arrJ) {
							out.print("<option value='" + j.getId() + "'>" + j.getNombre() + "</option>");

						}
					}
				%>
			</select> <label>Tipo Vehiculo</label> <select id="vehiculoTipo"
				name="vehiculoTipo" required="required">
				<%
				//Muestra los tipos de vehiculos en opciones

					if (arrV != null | !arrV.isEmpty()) {
						for (Vehiculo j : arrV) {
							out.print("<option value='" + j.getId() + "'>" + j.getNombre() + "</option>");

						}
					}
				%>
			</select> <label>Sexo</label> <select name="sexo" id="sexo"
				required="required">
				<%
				//Muestra los sexos en opciones

					if (arrS != null | !arrS.isEmpty()) {
						for (Sexo j : arrS) {
							out.print("<option value='" + j.getId() + "'>" + j.getNombre() + "</option>");

						}
					}
				%>
			</select> <input type="submit" value="Registrar">
		</form>

	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>