package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO de usuarios
 * @author HIBAN
 *
 */
@XmlRootElement
public class Usuario {
	private Integer id;
	private String nombre, pass;

	//constructores
	public Usuario(Integer id, String nombre, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
	}

	public Usuario() {
		super();
	}

	//getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
