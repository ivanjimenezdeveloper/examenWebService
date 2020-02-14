package model.entidad.dao.mapper;

import org.apache.ibatis.annotations.Param;

import model.entidad.Usuario;

public interface UsuarioMapper {

	public Usuario usuarioPorId(@Param("id") Integer id);

	public Usuario getUsuario(@Param("nombre") String nombre, @Param("pass") String pass);

}
