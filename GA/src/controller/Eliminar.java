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
 * Servlet que elimina un accidente
 * @author horabaixa
 *
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//EJBs
	@EJB
	SesionClienteEJB sesionEJB;

	@EJB
	AccidenteClienteEJB accidentesEjb;

	/**
	 * Recoge la id y elimina el accidente
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Usuario u = sesionEJB.usuarioLogeado(sesion);
		Integer id;
		//Recoge la id del accidente a eliminar
		try {
			id = Integer.parseInt(request.getParameter("id"));

		} catch (Exception e) {
			id = null;
		}
		//Si todo es correcto lo elimina
		if (u != null || !id.equals("") || id != null) {
			accidentesEjb.deleteAccidente(id);
		}

		//redirige a main
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/MainCliente");
		rs.forward(request, response);
	}



}
