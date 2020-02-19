package model.entidad.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Sexo;
import model.entidad.Tipos;
import model.entidad.Vehiculo;

public interface AccidentesMapper {

	public ArrayList<Accidente> busquedaGeneral();

	public Tipos TipoPorId(@Param("id") int id);

	public Accidente getAccidente(@Param("id") int id);

	public Distritos distritoPorId(@Param("id") int id);

	public ArrayList<Estadisticas> getEstadisticas(@Param("inicio") String inicio, @Param("fin") String fin);

	public ArrayList<Estadisticas> getEstadisticasSexo(@Param("inicio") String inicio, @Param("fin") String fin,
			@Param("distrito") Integer distrito);

	public ArrayList<Distritos> busquedaGeneralDistritos();

	public ArrayList<Tipos> busquedaGeneralTipos();

	public ArrayList<Sexo> getSexos();

	public ArrayList<Vehiculo> getVehiculos();

	public Integer insertAccidente(Accidente a);

	public Integer updateAccidente(Accidente a);
	
	public void deleteAccidente(@Param("id") Integer id);

}
