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

import model.ejb.AccidenteClienteEJB;
import model.ejb.SesionClienteEJB;
import model.entidad.Usuario;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionClienteEJB sesionEJB;

	@EJB
	AccidenteClienteEJB accidentesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Usuario u = sesionEJB.usuarioLogeado(sesion);
		Integer id;
		try {
			id = Integer.parseInt(request.getParameter("id"));

		} catch (Exception e) {
			id = null;
		}
		if (u != null || !id.equals("") || id != null) {
			accidentesEjb.deleteAccidente(id);
		}

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/MainCliente");
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
