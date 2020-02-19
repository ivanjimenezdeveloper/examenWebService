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

import model.ejb.SesionClienteEJB;

/**
 * Servlet que cierra la sesion
 * @author horabaixa
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//EJBs
	@EJB
	SesionClienteEJB sesionEJB;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		//hace el logout
		sesionEJB.logoutUsuario(sesion);
		//Redirige a login
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Login.jsp");
		rs.forward(request, response);	
	}



}
