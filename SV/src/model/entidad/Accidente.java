package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * POJO de la tabla accidentes
 * @author HIBAN
 *
 */
@XmlRootElement
public class Accidente {
	private Integer id, id_distrito, id_tipo_accidente, id_tipo_vehiculo, id_sexo;
	private String expediente, direccion ;
	private String fecha, hora;

	//Constructores
	public Accidente(Integer id, Integer id_distrito, Integer id_tipo_accidente, String expediente, String direccion,
			Integer id_tipo_vehiculo,Integer id_sexo, String fecha, String hora) {
		super();
		this.id = id;
		this.id_distrito = id_distrito;
		this.id_tipo_accidente = id_tipo_accidente;
		this.expediente = expediente;
		this.direccion = direccion;
		this.id_tipo_vehiculo = id_tipo_vehiculo;
		this.id_sexo = id_sexo;
		this.fecha = fecha;
		this.hora = hora;
	}
	

	public Accidente() {
		super();
	}


	//Getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdAccidente() {
		return id;
	}

	public void setIdAccidente(Integer id) {
		this.id = id;
	}

	public Integer getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(Integer id_distrito) {
		this.id_distrito = id_distrito;
	}
	public Integer getIdDistrito() {
		return id_distrito;
	}

	public void setIdDistrito(Integer id_distrito) {
		this.id_distrito = id_distrito;
	}
	public Integer getId_tipo_accidente() {
		return id_tipo_accidente;
	}

	public void setId_tipo_accidente(Integer id_tipo_accidente) {
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


	public Integer getId_tipo_vehiculo() {
		return id_tipo_vehiculo;
	}


	public void setId_tipo_vehiculo(Integer id_tipo_vehiculo) {
		this.id_tipo_vehiculo = id_tipo_vehiculo;
	}


	public Integer getId_sexo() {
		return id_sexo;
	}


	public void setId_sexo(Integer id_sexo) {
		this.id_sexo = id_sexo;
	}
	
	
}
