package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Accidente {
	private Integer id, id_distrito, id_tipo_accidente;
	private String expediente, direccion, tipo_vehiculo,  sexo ;
	private String fecha, hora;
	public Accidente(Integer id, Integer id_distrito, Integer id_tipo_accidente, String expediente, String direccion,
			String tipo_vehiculo, String sexo, String fecha, String hora) {
		super();
		this.id = id;
		this.id_distrito = id_distrito;
		this.id_tipo_accidente = id_tipo_accidente;
		this.expediente = expediente;
		this.direccion = direccion;
		this.tipo_vehiculo = tipo_vehiculo;
		this.sexo = sexo;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	
	
	public Accidente() {
		super();
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_distrito() {
		return id_distrito;
	}
	public void setId_distrito(Integer id_distrito) {
		this.id_distrito = id_distrito;
	}
	public Integer getId_tipo_accidente() {
		return id_tipo_accidente;
	}
	public void setId_tipo_accidente(Integer id_tipo_accidente) {
		this.id_tipo_accidente = id_tipo_accidente;
	}
	
	public Integer getIdAccidente() {
		return id_tipo_accidente;
	}
	public void setIdAccidente(Integer id_tipo_accidente) {
		this.id_tipo_accidente = id_tipo_accidente;
	}
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}
	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}


}
