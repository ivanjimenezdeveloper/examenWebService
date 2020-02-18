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

/**
 * Servlet implementation class MostrarAccidentes
 */
@WebServlet("/MostrarAccidentes")
public class MostrarAccidentes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccidenteClienteEJB accidentesEjb;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		HttpSession sesion = request.getSession(true);
		ArrayList<Accidente> arr = accidentesEjb.busquedaGeneral();
		sesion.setAttribute("accidentes",arr );
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/accidentes.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
