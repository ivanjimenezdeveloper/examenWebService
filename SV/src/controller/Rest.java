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

@Path("Accidente")
public class Rest {

	@Context
	HttpServletRequest request;
	@EJB
	AccidenteEJB accidenteEJB;
	@EJB
	SesionEJB sesionEJB;

	@GET
	@Path("/getAccidente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Accidente getJugador(@PathParam("id") int id) {
		Accidente a = new Accidente();

		a = accidenteEJB.getAccidente(id);

		return a;

	}

	@GET
	@Path("/getAccidentes/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Accidente> busquedaGeneralAccidentes() {
		ArrayList<Accidente> a = new ArrayList<Accidente>();

		a = accidenteEJB.busquedaGeneral();

		return a;

	}

	@GET
	@Path("/getDistritos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		ArrayList<Distritos> a = new ArrayList<Distritos>();

		a = accidenteEJB.busquedaGeneralDistritos();

		return a;

	}

	@GET
	@Path("/getSexos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sexo> getSexos() {
		ArrayList<Sexo> a = new ArrayList<Sexo>();

		a = accidenteEJB.getSexos();

		return a;

	}

	@GET
	@Path("/getTipos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Tipos> busquedaGeneralTipos() {
		ArrayList<Tipos> a = new ArrayList<Tipos>();

		a = accidenteEJB.busquedaGeneralTipos();

		return a;

	}

	@GET
	@Path("/getVehiculos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vehiculo> getVehiculos() {
		ArrayList<Vehiculo> a = new ArrayList<Vehiculo>();

		a = accidenteEJB.getVehiculos();

		return a;

	}


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
	
	@POST
	@Path("/insertAccidente/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Integer insertAccidente(Accidente a) {
		
		return accidenteEJB.insertAccidente(a);
	}
	


}
