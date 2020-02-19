package model.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Sexo;
import model.entidad.Tipos;
import model.entidad.Usuario;
import model.entidad.Vehiculo;

/**
 * EJB que accede al REST
 * 
 * @author HIBAN
 *
 */
@Stateless(mappedName = "accidenteejotabe")
@LocalBean
public class AccidenteClienteEJB {
	private final String TOKEN = "patata23";

	/**
	 * Busqueda de todos los accidentes
	 * 
	 * @return ArrayList con los accidentes
	 */
	public ArrayList<Accidente> busquedaGeneral() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getAccidentes"+"/" +TOKEN);

		ArrayList<Accidente> a;
		a = (ArrayList<Accidente>) target1.request().get(new GenericType<List<Accidente>>() {
		});

		return a;

	}

	/**
	 * Recupera un accidente segun su id
	 * @param id id del accidente
	 * @return
	 */
	public Accidente getAccidente(int id) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getAccidente/" + id +"/" +TOKEN);

		Accidente a;
		a = (Accidente) target1.request().get(Accidente.class);

		return a;

	}

	/**
	 * Devuelve todos los tipos de accidentes
	 * 
	 * @return ArrayList de tipos de accidentes
	 */

	public ArrayList<Tipos> getTipos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getTipos"+"/" +TOKEN);

		ArrayList<Tipos> a;
		a = (ArrayList<Tipos>) target1.request().get(new GenericType<List<Tipos>>() {
		});

		return a;

	}

	/**
	 * Devuelve todos los distritos
	 * 
	 * @return ArrayList de Distritos
	 */
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getDistritos"+"/" +TOKEN);

		ArrayList<Distritos> a;
		a = (ArrayList<Distritos>) target1.request().get(new GenericType<List<Distritos>>() {
		});

		return a;
	}

	/**
	 * Recupera todos los sexos
	 * @return Arraylist de sexos
	 */
	public ArrayList<Sexo> getSexos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getSexos"+"/" +TOKEN);

		ArrayList<Sexo> a;
		a = (ArrayList<Sexo>) target1.request().get(new GenericType<List<Sexo>>() {
		});

		return a;
	}

	/**
	 * Recupera todos los vehiculos
	 * @return Arraylist de vehiculos
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getVehiculos"+"/" +TOKEN);

		ArrayList<Vehiculo> a;
		a = (ArrayList<Vehiculo>) target1.request().get(new GenericType<List<Vehiculo>>() {
		});

		return a;
	}

	/**
	 * Instera un accidente
	 * @param a accidente a insertar
	 */
	public void insertAccidente(Accidente a) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/insertAccidente"+"/" +TOKEN);

		target1.request().post(Entity.json(a));

	}

	/**
	 * Actualiza un accidente
	 * @param a accidente a actualizar
	 */
	public void updateAccidente(Accidente a) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/updateAccidente"+"/" +TOKEN);

		target1.request().post(Entity.json(a));

	}
	
	/**
	 * Logea al usuario
	 * @param a usuario a logear
	 * @return Integer que muestra si ha funcionado o no
	 */
	public Integer logearUsuario(Usuario a) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/logearUsuario");

		return target1.request().post(Entity.json(a), Integer.class);
	}
	
	/**
	 * Borra un accidente
	 * @param i id del accidente a borrar
	 */
	public void deleteAccidente(Integer i) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/deleteAccidente/"+i+"/"+TOKEN);

		 target1.request().delete();
	}

}
