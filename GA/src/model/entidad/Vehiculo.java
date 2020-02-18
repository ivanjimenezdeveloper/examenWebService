package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehiculo {
	
	private int id;
	private String nombre;
	
	/**
	 * Constructor de tipos
	 * @param id id del tipo
	 * @param nombre nombre del tipo
	 */
	public Vehiculo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Vehiculo() {
		super();
	}
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