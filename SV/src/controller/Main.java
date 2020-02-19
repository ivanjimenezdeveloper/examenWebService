package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.AccidenteEJB;

/**
 * Pagina principal de SV
 * @author HIBAN
 *
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	
	//EJB de accidentes
	@EJB
	AccidenteEJB accidenteEJB;

	/**
	 * Recupera datos de estadisticas de la base de datos y lo muestran
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		//coge el parametro de eleccion
		String eleccion = request.getParameter("e");
		HttpSession sesion = request.getSession(true);

		//si hay algo en eleccion entra
		if (eleccion != null) {
			//guarda la eleccion en el atributo
			sesion.setAttribute("eleccion", eleccion);

			//si es df ira al jsp de eleccion de fecha y si no al de elegir fecha y sexo
			if (eleccion.equals("df")) {
				
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/elegirFechaF.jsp");
				rs.forward(request, response);
			} else if (eleccion.equals("sv")) {
				//rellena los distritos
				sesion.setAttribute("distritos", accidenteEJB.busquedaGeneralDistritos());

				RequestDispatcher rs = getServletContext().getRequestDispatcher("/elegirFechaSexo.jsp");
				rs.forward(request, response);
			}
		} else {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
			rs.forward(request, response);
		}

	}

	/**
	 * Muestra las estadisticas segun la eleccion
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		Integer distrito = 0;
		//Recupera los datos del formulario
		HttpSession sesion = request.getSession(true);
		String eleccion = (String) sesion.getAttribute("eleccion");
		String fin = request.getParameter("fin");
		String inicio = request.getParameter("inicio");
		try {
			 distrito = Integer.parseInt(request.getParameter("distrito"));

		} catch (Exception e) {
		}

		//recupera los datos segun la eleccion y redirige a mostrar las estadisticas
		if (eleccion.equals("df")) {
			sesion.setAttribute("estadisticas", accidenteEJB.getEstadisticas(inicio, fin));

			RequestDispatcher rs = getServletContext().getRequestDispatcher("/estadisticas.jsp");
			rs.forward(request, response);
		} else if (eleccion.equals("sv")) {
			sesion.setAttribute("estadisticas", accidenteEJB.getEstadisticasSexo(inicio, fin, distrito));
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/estadisticas.jsp");
			rs.forward(request, response);
		}

	}

}
