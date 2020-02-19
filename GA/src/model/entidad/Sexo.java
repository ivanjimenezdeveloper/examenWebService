package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO de sexo
 * @author HIBAN
 *
 */
@XmlRootElement
public class Sexo {
	
	private int id;
	private String nombre;
	
	//constructores
	public Sexo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Sexo() {
		super();
	}
	
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
