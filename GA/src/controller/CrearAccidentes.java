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

/**
 * Servlet implementation class CrearAccidentes
 */
@WebServlet("/CrearAccidentes")
public class CrearAccidentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	@EJB
	AccidenteClienteEJB accidentesEjb;

	public CrearAccidentes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		HttpSession sesion = request.getSession(true);
		ArrayList<Tipos> arr = accidentesEjb.getTipos();
		ArrayList<Distritos> arrD = accidentesEjb.busquedaGeneralDistritos();
		ArrayList<Sexo> arrS = accidentesEjb.getSexos();
		ArrayList<Vehiculo> arrV = accidentesEjb.getVehiculos();

		sesion.setAttribute("tipos", arr);
		sesion.setAttribute("distritos", arrD);
		sesion.setAttribute("sexos", arrS);
		sesion.setAttribute("vehiculos", arrV);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearAccidente.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String expediente, fecha, horas, minutos, direccion, vehiculo, sexo;
		Integer distrito, accidente;
		try {
			expediente = request.getParameter("expediente");
			fecha = request.getParameter("fecha");
			horas = request.getParameter("hora");
			minutos = request.getParameter("minuto");
			direccion = request.getParameter("direccion");
			distrito = Integer.parseInt(request.getParameter("distrito"));
			accidente = Integer.parseInt(request.getParameter("accidenteTipo"));
			vehiculo = request.getParameter("vehiculoTipo");
			sexo = request.getParameter("sexo");

			Accidente a = new Accidente(0, distrito, accidente, expediente, direccion, vehiculo, sexo, fecha,
					horas + ":" + minutos + ":00");

		} catch (Exception e) {
			expediente = "";
			fecha = "";
			horas = "";
			minutos = "";
			direccion = "";
			vehiculo = "";
			sexo = "";
			distrito = -1;
			accidente = -1;

		}
		
		Accidente a = new Accidente(0, distrito, accidente, expediente, direccion, vehiculo, sexo, fecha,
				horas + ":" + minutos + ":00");
		
		accidentesEjb.insertAccidente(a);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
		rs.forward(request, response);

	}

}
