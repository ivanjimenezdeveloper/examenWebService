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

	/**
	 * Devuelve estadisticas segun los datos
	 * @param inicio fecha de inicio
	 * @param fin fecha fin
	 * @param distrito distrito que mirar
	 * @return arraylist de estadisticas
	 */
	public ArrayList<Estadisticas> getEstadisticasSexo(String inicio, String fin, Integer distrito) {
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

	/**
	 * Recupera un usuario por id
	 * @param id id de usuario
	 * @return objeto usuario
	 */
	public Usuario usuarioPorId(Integer id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.usuarioPorId(id);
	}

	/**
	 * Recupera el usuario segun su pass y nombre
	 * @param nombre nombre de usuario
	 * @param pass pass del usuario
	 * @return objeto usuario
	 */
	public Usuario getUsuario(String nombre, String pass) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getUsuario(nombre, pass);
	}

	/**
	 * Recupera los sexos
	 * @return arraylist de sexos
	 */
	public ArrayList<Sexo> getSexos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getSexos();
	}

	/**
	 * Recupera los vehiculos
	 * @return arraylist de vehiculos
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getVehiculos();
	}

	/**
	 * Inserta un accidente
	 * @param a accidente a insertar
	 * @return 1 o 0 segun si funciona el insert
	 */
	public Integer insertAccidente(Accidente a) {
		AccidenteDAO ab = new AccidenteDAO();

		return ab.insertAccidente(a);

	}

	/**
	 * Actualiza un accidente
	 * @param a accidente a actualizar
	 * @return 1 o 0 segun si funciona la actualizacion
	 */
	public Integer updateAccidente(Accidente a) {
		AccidenteDAO ab = new AccidenteDAO();

		return ab.updateAccidente(a);

	}
}
