package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO de estadisticas
 * @author HIBAN
 *
 */
@XmlRootElement
public class Estadisticas {
	private String distrito, tipo, vehiculo, sexo;
	private Integer cantidad;

	//constructores
	public Estadisticas(String distrito, String tipo, String vehiculo, String sexo, Integer cantidad) {
		super();
		this.distrito = distrito;
		this.tipo = tipo;
		this.vehiculo = vehiculo;
		this.sexo = sexo;
		this.cantidad = cantidad;
	}


	public Estadisticas() {
		super();
	}

	// Getters y setters
	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

}
