package controller;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * 
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
	private final String TOKEN = "patata23";

	/**
	 * Envia un accidente
	 * 
	 * @param id id de accidente
	 * @return accidente
	 */
	@GET
	@Path("/getAccidente/{id}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Accidente getJugador(@PathParam("id") int id, @PathParam("token") String token) {
		Accidente a = new Accidente();

		if (token.equals(TOKEN)) {

			a = accidenteEJB.getAccidente(id);

			return a;
		}

		return a;
	}

	/**
	 * Recupera todos los accidentes
	 * 
	 * @return arraylist de accidentes
	 */
	@GET
	@Path("/getAccidentes/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Accidente> busquedaGeneralAccidentes(@PathParam("token") String token) {
		ArrayList<Accidente> a = new ArrayList<Accidente>();
		if (token.equals(TOKEN)) {
			a = accidenteEJB.busquedaGeneral();

			return a;
		}
		return a;

	}

	/**
	 * Recupera los distritos
	 * 
	 * @return arraylist de distritos
	 */
	@GET
	@Path("/getDistritos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Distritos> busquedaGeneralDistritos(@PathParam("token") String token) {
		ArrayList<Distritos> a = new ArrayList<Distritos>();
		if (token.equals(TOKEN)) {
			a = accidenteEJB.busquedaGeneralDistritos();

			return a;
		}
		return a;

	}

	/**
	 * Recupera los sexos
	 * 
	 * @return arraylist de sexos
	 */
	@GET
	@Path("/getSexos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sexo> getSexos(@PathParam("token") String token) {
		ArrayList<Sexo> a = new ArrayList<Sexo>();
		if (token.equals(TOKEN)) {
			a = accidenteEJB.getSexos();

			return a;
		}
		return a;

	}

	/**
	 * Recupera los tipos de accidentes
	 * 
	 * @return arraylist de tipos de accidentes
	 */
	@GET
	@Path("/getTipos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Tipos> busquedaGeneralTipos(@PathParam("token") String token) {
		ArrayList<Tipos> a = new ArrayList<Tipos>();
		if (token.equals(TOKEN)) {
			a = accidenteEJB.busquedaGeneralTipos();

			return a;
		}
		return a;
	}

	/**
	 * Recupera los vehiculos
	 * 
	 * @return arraylist de vehiculos
	 */
	@GET
	@Path("/getVehiculos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vehiculo> getVehiculos(@PathParam("token") String token) {
		ArrayList<Vehiculo> a = new ArrayList<Vehiculo>();
		if (token.equals(TOKEN)) {
			a = accidenteEJB.getVehiculos();

			return a;
		}
		return a;

	}

	/**
	 * Log in de ususario donde verifica si existe el usuario con ese nombre y
	 * contrase�a
	 * 
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
			try {
				Usuario us = accidenteEJB.getUsuario(a.getNombre(), a.getPass());
				
				if(us != null) {
					return 1;
	
				}else {
					return 0;
				}
			} catch (Exception e) {
				return 0;
			}

		} else {
			return 0;
		}

	}

	/**
	 * Inserta un accidente
	 * 
	 * @param a accidente a insertar
	 * @return 1 o 0 segun si funciona el insert
	 */
	@POST
	@Path("/insertAccidente/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Integer insertAccidente(Accidente a, @PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return accidenteEJB.insertAccidente(a);
		}
		return 0;
	}

	/**
	 * Actualiza un accidente
	 * 
	 * @param a accidente a actualizar
	 * @return 1 o 0 segun si funciona la actualizacion
	 */
	@POST
	@Path("/updateAccidente/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Integer updateAccidente(Accidente a, @PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return accidenteEJB.updateAccidente(a);
		}
		return 0;
	}

	@DELETE
	@Path("/deleteAccidente/{id}/{token}")
	public void deleteAccidente(@PathParam("id") Integer id, @PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			accidenteEJB.deleteAccidente(id);
		}
	}

}
