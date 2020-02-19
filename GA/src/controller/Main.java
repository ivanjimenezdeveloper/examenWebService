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
 * Main que muestra el menu principal y la pagina de login
 * @author horabaixa
 *
 */
@WebServlet("/MainCliente")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
//EJBs
	@EJB
	AccidenteClienteEJB accidentesEjb;

	@EJB
	SesionClienteEJB sesionEJB;
	/**
	 * EJB que muestra el main si hay un usuario logeado o redirige al login
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		HttpSession sesion = request.getSession(true);
		Usuario u =sesionEJB.usuarioLogeado(sesion);
		
		//Si el usuario es null redirige al login o muestra el main
		if(u == null) {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Login.jsp");
			rs.forward(request, response);	
		}else {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
			rs.forward(request, response);
		}

	}

	/**
	 * Logea al usuario
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Recoge los parametros
		String usuario = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Usuario u = new Usuario();
		
		u.setNombre(usuario);
		u.setPass(pass);
		HttpSession sesion = request.getSession(true);
		//Busca el usuario en la base de datos
		int loged = accidentesEjb.logearUsuario(u);
		
		//si existia el usuario con esa password mete al usuario en la sesion, en caso contrario devuelve al main directamente
		if(loged == 1) {
			sesionEJB.loginUsuario(sesion, u);
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/main.jsp");
			rs.forward(request, response);
		}else {
			response.sendRedirect("MainCliente");
		}
		

	}

}
