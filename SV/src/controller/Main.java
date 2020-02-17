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
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccidenteEJB accidenteEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eleccion = request.getParameter("e");
		HttpSession sesion = request.getSession(true);

		if (eleccion != null) {
			sesion.setAttribute("eleccion", eleccion);

			if (eleccion.equals("df")) {
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/elegirFechaF.jsp");
				rs.forward(request, response);
			} else if (eleccion.equals("sv")) {
				sesion.setAttribute("distritos", accidenteEJB.busquedaGeneralDistritos());

				RequestDispatcher rs = getServletContext().getRequestDispatcher("/elegirFechaSexo.jsp");
				rs.forward(request, response);
			}
		} else {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
			rs.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);
		String eleccion = (String) sesion.getAttribute("eleccion");
		String fin = request.getParameter("fin");
		String inicio = request.getParameter("inicio");
		String distrito = request.getParameter("distrito");

		
		if(eleccion.equals("df")) {
			sesion.setAttribute("estadisticas", accidenteEJB.getEstadisticas(inicio, fin));

			RequestDispatcher rs = getServletContext().getRequestDispatcher("/estadisticas.jsp");
			rs.forward(request, response);	
		}else if (eleccion.equals("sv")) {
			sesion.setAttribute("estadisticas", accidenteEJB.getEstadisticasSexo(inicio, fin, distrito));
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/estadisticas.jsp");
			rs.forward(request, response);	
		}

	}

}
