package controller;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.ejb.AccidenteEJB;
import model.ejb.SesionEJB;
import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Sexo;
import model.entidad.Tipos;
import model.entidad.Usuario;
import model.entidad.Vehiculo;

/**
 * Servicio rest para la base de accidentes de 2019
 * @author HIBAN
 *
 */
@Path("Accidente")
public class Rest {

	// recupera la request
	@Context
	HttpServletRequest request;
	// EJBs
	@EJB
	AccidenteEJB accidenteEJB;
	@EJB
	SesionEJB sesionEJB;

	/**
	 * Envia un accidente
	 * 
	 * @param id id de accidente
	 * @return accidente
	 */
	@GET
	@Path("/getAccidente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Accidente getJugador(@PathParam("id") int id) {
		Accidente a = new Accidente();

		a = accidenteEJB.getAccidente(id);

		return a;

	}

	/**
	 * Recupera todos los accidentes
	 * @return arraylist de accidentes
	 */
	@GET
	@Path("/getAccidentes/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Accidente> busquedaGeneralAccidentes() {
		ArrayList<Accidente> a = new ArrayList<Accidente>();

		a = accidenteEJB.busquedaGeneral();

		return a;

	}

	/**
	 * Recupera los distritos
	 * @return arraylist de distritos
	 */
	@GET
	@Path("/getDistritos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		ArrayList<Distritos> a = new ArrayList<Distritos>();

		a = accidenteEJB.busquedaGeneralDistritos();

		return a;

	}

	/**
	 * Recupera los sexos
	 * @return arraylist de sexos
	 */
	@GET
	@Path("/getSexos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sexo> getSexos() {
		ArrayList<Sexo> a = new ArrayList<Sexo>();

		a = accidenteEJB.getSexos();

		return a;

	}

	/**
	 * Recupera los tipos de accidentes
	 * @return arraylist de tipos de accidentes
	 */
	@GET
	@Path("/getTipos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Tipos> busquedaGeneralTipos() {
		ArrayList<Tipos> a = new ArrayList<Tipos>();

		a = accidenteEJB.busquedaGeneralTipos();

		return a;
	}

	/**
	 * Recupera los vehiculos
	 * @return arraylist de vehiculos
	 */
	@GET
	@Path("/getVehiculos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vehiculo> getVehiculos() {
		ArrayList<Vehiculo> a = new ArrayList<Vehiculo>();

		a = accidenteEJB.getVehiculos();

		return a;

	}

	/**
	 * Log in de ususario donde verifica si existe el usuario con ese nombre y contraseña
	 * @param a usuario a verificar
	 * @return 1 o 0 segun si existe o no
	 */
	@POST
	@Path("/logearUsuario/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Integer logeaUsuario(Usuario a) {
		HttpSession sesion = request.getSession(true);

		Usuario u = sesionEJB.usuarioLogeado(sesion);

		// si el usuario es nulo procedera a hacer login
		if (u == null) {
			// comprueba que exista el usuario
			u = accidenteEJB.getUsuario(a.getNombre(), a.getPass());

			if (u.getId() != null) {

				// sesionEJB.loginUsuario(sesion, u);

				return 1;
			} else {
				return 0;
			}

		} else {
			return 0;
		}

	}

	/**
	 * Inserta un accidente
	 * @param a accidente a insertar
	 * @return 1 o 0 segun si funciona el insert
	 */
	@POST
	@Path("/insertAccidente/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Integer insertAccidente(Accidente a) {

		return accidenteEJB.insertAccidente(a);
	}

	/**
	 * Actualiza un accidente
	 * @param a accidente a actualizar
	 * @return 1 o 0 segun si funciona la actualizacion
	 */
	@POST
	@Path("/updateAccidente/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Integer updateAccidente(Accidente a) {

		return accidenteEJB.updateAccidente(a);
	}

}
