package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.AccidenteClienteEJB;
import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Sexo;
import model.entidad.Tipos;
import model.entidad.Vehiculo;

@WebServlet("/ModificarAccidente")
public class ModificarAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	@EJB
	AccidenteClienteEJB accidentesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		Integer id = -1;
		try {
			id = Integer.valueOf(request.getParameter("id"));
			

		} catch (Exception e) {
			
		}
		
		HttpSession sesion = request.getSession(true);
		
		if(id> 0) {
			Accidente acc = accidentesEjb.getAccidente(id);
			ArrayList<Tipos> arr = accidentesEjb.getTipos();
			ArrayList<Distritos> arrD = accidentesEjb.busquedaGeneralDistritos();
			ArrayList<Sexo> arrS = accidentesEjb.getSexos();
			ArrayList<Vehiculo> arrV = accidentesEjb.getVehiculos();

			sesion.setAttribute("tipos", arr);
			sesion.setAttribute("distritos", arrD);
			sesion.setAttribute("sexos", arrS);
			sesion.setAttribute("vehiculos", arrV);
			sesion.setAttribute("accidente", acc);
			
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/modificarAccidente.jsp");
			rs.forward(request, response);
		}else {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
			rs.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String expediente, fecha, horas, minutos, direccion ;
		Integer distrito, accidente, vehiculo, sexo;
		HttpSession sesion = request.getSession(true);
		Accidente ab = (Accidente)sesion.getAttribute("accidente");
		try {
			expediente = request.getParameter("expediente");
			fecha = request.getParameter("fecha");
			horas = request.getParameter("hora");
			minutos = request.getParameter("minuto");
			direccion = request.getParameter("direccion");
			distrito = Integer.parseInt(request.getParameter("distrito"));
			accidente = Integer.parseInt(request.getParameter("accidenteTipo"));
			vehiculo = Integer.parseInt(request.getParameter("vehiculoTipo"));
			sexo = Integer.parseInt(request.getParameter("sexo"));



		} catch (Exception e) {
			expediente = "";
			fecha = "";
			horas = "";
			minutos = "";
			direccion = "";
			vehiculo = -1;
			sexo = -1;
			distrito = -1;
			accidente = -1;

		}

		Accidente a = new Accidente(ab.getId(), distrito, accidente, expediente, direccion, vehiculo, sexo, fecha,
				horas + ":" + minutos + ":00");

		accidentesEjb.updateAccidente(a);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
		rs.forward(request, response);

	}

}
