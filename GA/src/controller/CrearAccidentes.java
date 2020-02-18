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
import model.entidad.Tipos;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		HttpSession sesion = request.getSession(true);
		ArrayList<Tipos> arr = accidentesEjb.getTipos();
		ArrayList<Distritos> arrD = accidentesEjb.busquedaGeneralDistritos();
		sesion.setAttribute("tipos",arr );
		sesion.setAttribute("distritos", arrD);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearAccidente.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
