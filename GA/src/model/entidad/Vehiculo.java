package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO de vehiculos
 * @author HIBAN
 *
 */
@XmlRootElement
public class Vehiculo {
	
	private int id;
	private String nombre;
	
	//constructores
	public Vehiculo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Vehiculo() {
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