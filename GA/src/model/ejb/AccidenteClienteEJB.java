package model.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Tipos;

@Stateless(mappedName = "accidenteejotabe")
@LocalBean
public class AccidenteClienteEJB {

	public ArrayList<Accidente> busquedaGeneral() {
		Client cliente = ClientBuilder.newClient();
		
		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getAccidentes"); 
		
		ArrayList<Accidente> a;
		a = (ArrayList<Accidente>) target1.request().get(new GenericType<List<Accidente>>(){});

		
		return a;

	}
//
//	public ArrayList<Accidente> busquedaAccidente(String tipo, String fecha) {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.busquedaAccidente(tipo, fecha);
//
//	}
//
//	public ArrayList<Accidente> busquedaAccidenteDespues(String tipo, String fecha) {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.busquedaAccidenteDespues(tipo, fecha);
//
//	}
//
//	public Tipos TipoPorId(int id) {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.TipoPorId(id);
//
//	}
//
//	public Accidente getAccidente(int id) {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.getAccidente(id);
//
//	}
//
//	public Distritos distritoPorId(int id) {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.distritoPorId(id);
//
//	}
//
//	public ArrayList<Estadisticas> getEstadisticas() {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.getEstadisticas();
//
//	}
//
	public ArrayList<Tipos> getTipos() {
		Client cliente = ClientBuilder.newClient();
		
		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getTipos"); 
		
		ArrayList<Tipos> a;
		a = (ArrayList<Tipos>) target1.request().get(new GenericType<List<Tipos>>(){});

		
		return a;

	}

	public ArrayList<Distritos> busquedaGeneralDistritos() {
		Client cliente = ClientBuilder.newClient();
		
		WebTarget target1 = cliente.target("http://localhost:8080/SV/Accidente/getDistritos"); 
		
		ArrayList<Distritos> a;
		a = (ArrayList<Distritos>) target1.request().get(new GenericType<List<Distritos>>(){});

		
		return a;
	}
//
//	public ArrayList<Tipos> busquedaGeneralTipos() {
//		AccidenteDAO a = new AccidenteDAO();
//
//		return a.busquedaGeneralTipos();
//	}
}
