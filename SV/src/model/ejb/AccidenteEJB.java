package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;

import model.MyBatisUtil;
import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Sexo;
import model.entidad.Tipos;
import model.entidad.Usuario;
import model.entidad.Vehiculo;
import model.entidad.dao.AccidenteDAO;
import model.entidad.dao.mapper.AccidentesMapper;

@Stateless
@LocalBean
/**
 * EJB que lleva la logica de negocio sobre los accidentes
 * 
 * @author HIBAN
 *
 */
public class AccidenteEJB {

	/**
	 * Busqueda de todos los accidentes
	 * 
	 * @return ArrayList con los accidentes
	 */
	public ArrayList<Accidente> busquedaGeneral() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneral();

	}

	/**
	 * Busca los accidentes segun el tipo y fecha
	 * 
	 * @param tipo  tipo de accidente
	 * @param fecha fecha inicial
	 * @return ArrayList de accidentes
	 */
	public ArrayList<Accidente> busquedaAccidente(String tipo, String fecha) {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaAccidente(tipo, fecha);

	}

	/**
	 * Busqueda de accidentes despues de la fecha dada
	 * 
	 * @param tipo  tipo de accidente
	 * @param fecha fecha inicial
	 * @return Arraylist de accidentes
	 */
	public ArrayList<Accidente> busquedaAccidenteDespues(String tipo, String fecha) {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaAccidenteDespues(tipo, fecha);

	}

	/**
	 * Busqueda de tipo por id
	 * 
	 * @param id id del tipo de accidente
	 * @return Objeto de tipos
	 */
	public Tipos TipoPorId(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.TipoPorId(id);

	}

	/**
	 * Conseguir un accidente por id
	 * 
	 * @param id id del accidente
	 * @return objeto accidente
	 */
	public Accidente getAccidente(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getAccidente(id);

	}

	/**
	 * Consigue un distrito por id
	 * 
	 * @param id id del distrito
	 * @return objeto distrito
	 */
	public Distritos distritoPorId(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.distritoPorId(id);

	}

	/**
	 * Devuelve todas las estadisticas
	 * 
	 * @return Arraylist con todas las estadisticas
	 */
	public ArrayList<Estadisticas> getEstadisticas(String inicio, String fin) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getEstadisticas(inicio, fin);

	}

	public ArrayList<Estadisticas> getEstadisticasSexo(String inicio, String fin, String distrito) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getEstadisticasSexo(inicio, fin, distrito);

	}

	/**
	 * Devuelve todos los distritos
	 * 
	 * @return ArrayList de Distritos
	 */
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneralDistritos();
	}

	/**
	 * Devuelve todos los tipos de accidentes
	 * 
	 * @return ArrayList de tipos de accidentes
	 */

	public ArrayList<Tipos> busquedaGeneralTipos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneralTipos();
	}

	public Usuario usuarioPorId(Integer id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.usuarioPorId(id);
	}

	public Usuario getUsuario(String nombre, String pass) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getUsuario(nombre, pass);
	}

	public ArrayList<Sexo> getSexos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getSexos();
	}
	public ArrayList<Vehiculo> getVehiculos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getVehiculos();
	}
	
	public Integer insertAccidente(Accidente a) {
		AccidenteDAO ab = new AccidenteDAO();
		
		return ab.insertAccidente(a);
		
		

	}
}
