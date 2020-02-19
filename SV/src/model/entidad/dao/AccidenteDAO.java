package model.entidad.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Sexo;
import model.entidad.Tipos;
import model.entidad.Usuario;
import model.entidad.Vehiculo;
import model.entidad.dao.mapper.AccidentesMapper;
import model.entidad.dao.mapper.UsuarioMapper;

public class AccidenteDAO implements AccidentesMapper{
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AccidenteDAO.class);

	/**
	 * Busqueda de todos los accidentes
	 * @return ArrayList con los accidentes
	 */
	public ArrayList<Accidente> busquedaGeneral() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaGeneral();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Accidente> uArr = new ArrayList<Accidente>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Busqueda de tipo por id
	 * @param id id del tipo de accidente
	 * @return Objeto de tipos
	 */
	@Override
	public Tipos TipoPorId(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.TipoPorId(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Tipos t = new Tipos();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Conseguir un accidente por id
	 * @param id id del accidente
	 * @return objeto accidente
	 */
	@Override
	public Accidente getAccidente(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getAccidente(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Accidente t = new Accidente();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Consigue un distrito por id
	 * @param id id del distrito
	 * @return objeto distrito
	 */
	@Override
	public Distritos distritoPorId(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.distritoPorId(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Distritos t = new Distritos();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Devuelve todas las estadisticas
	 * @return Arraylist con todas las estadisticas
	 */
	@Override
	public ArrayList<Estadisticas> getEstadisticas(String inicio, String fin) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getEstadisticas(inicio, fin);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Estadisticas> uArr = new ArrayList<Estadisticas>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}
	
	
	/**
	 * Devuelve todos los distritos
	 * @return ArrayList de Distritos
	 */
	@Override
	public ArrayList<Accidente> busquedaAccidente(String tipo, String fecha) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaAccidente(tipo, fecha);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Accidente> uArr = new ArrayList<Accidente>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}


	/**
	 * Busqueda de accidentes despues de la fecha dada
	 * @param tipo tipo de accidente
	 * @param fecha fecha inicial
	 * @return Arraylist de accidentes
	 */
	@Override
	public ArrayList<Accidente> busquedaAccidenteDespues(String tipo, String fecha) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaAccidenteDespues(tipo, fecha);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Accidente> uArr = new ArrayList<Accidente>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Devuelve todos los distritos
	 * @return ArrayList de Distritos
	 */
	@Override
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaGeneralDistritos();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Distritos> uArr = new ArrayList<Distritos>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Devuelve todos los tipos de accidentes
	 * @return ArrayList de tipos de accidentes
	 */
	@Override
	public ArrayList<Tipos> busquedaGeneralTipos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.busquedaGeneralTipos();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Tipos> uArr = new ArrayList<Tipos>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}
	
	public Usuario usuarioPorId(Integer id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.usuarioPorId(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Usuario t = new Usuario();
			return t;
		} finally {
			sqlSession.close();
		}
	}
	
	public Usuario getUsuario(String nombre, String pass) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.getUsuario(nombre, pass);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Usuario t = new Usuario();
			return t;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Estadisticas> getEstadisticasSexo(String inicio, String fin, String distrito) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getEstadisticasSexo(inicio, fin, distrito);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Estadisticas> uArr = new ArrayList<Estadisticas>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Sexo> getSexos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getSexos();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Sexo> uArr = new ArrayList<Sexo>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Vehiculo> getVehiculos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidenteMapper.getVehiculos();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Vehiculo> uArr = new ArrayList<Vehiculo>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Integer insertAccidente(Accidente a) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			accidenteMapper.insertAccidente(a);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {

			return 0;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Integer updateAccidente(Accidente a) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidenteMapper = sqlSession.getMapper(AccidentesMapper.class);
			accidenteMapper.updateAccidente(a);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {

			return 0;
		} finally {
			sqlSession.close();
		}
	}

}
