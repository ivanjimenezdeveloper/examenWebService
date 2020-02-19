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
import model.ejb.SesionClienteEJB;
import model.entidad.Accidente;
import model.entidad.Usuario;

/**
 * Servlet que muestra todos los accidentes
 * @author HIBAN
 *
 */
@WebServlet("/MostrarAccidentes")
public class MostrarAccidentes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccidenteClienteEJB accidentesEjb;
	@EJB
	SesionClienteEJB sesionEJB;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * Recoge todos los accidentes y redirige al JSP
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		HttpSession sesion = request.getSession(true);
		Usuario u =sesionEJB.usuarioLogeado(sesion);
		
		if(u != null) {
			//recoge los accidentes y los guarda en la sesion
			ArrayList<Accidente> arr = accidentesEjb.busquedaGeneral();
			sesion.setAttribute("accidentes",arr );
			//redirige
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/accidentes.jsp");
			rs.forward(request, response);
	
		}else {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Login.jsp");
			rs.forward(request, response);
		}

	}



}
