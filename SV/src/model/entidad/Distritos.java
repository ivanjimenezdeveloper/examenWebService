package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO de distritos
 * @author HIBAN
 *
 */
@XmlRootElement
public class Distritos {
	private int id;
	private String nombre;
	//Constructores
	public Distritos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Distritos() {
		super();
	}
	//Getters y Setters
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
