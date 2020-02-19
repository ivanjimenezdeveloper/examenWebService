package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO de tipos
 * @author HIBAN
 *
 */
@XmlRootElement
public class Tipos {
	private int id;
	private String nombre;
	//constructores
	public Tipos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Tipos() {
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
