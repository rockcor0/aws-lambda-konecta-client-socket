/**
 * 
 */
package com.konecta.websocket.service.vo;

/**
 * @author RicardoDelgado
 *
 */
public class VOResponse {

	private String code; 
	private String serviceCode;
	private String connid;
	private String identificacion;
	private String nombre;
	private String paciente;
	private String codFoc;
	private String entidad;
	private String estado;
	private String endSeparator;
	
	
	/**
	 * @param code
	 * @param serviceCode
	 * @param connid
	 * @param identificacion
	 * @param nombre
	 * @param paciente
	 * @param codFoc
	 * @param entidad
	 * @param estado
	 * @param endSeparator
	 */
	public VOResponse(String code, String serviceCode, String connid, String identificacion, String nombre,
			String paciente, String codFoc, String entidad, String estado, String endSeparator) {
		super();
		this.code = code;
		this.serviceCode = serviceCode;
		this.connid = connid;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.paciente = paciente;
		this.codFoc = codFoc;
		this.entidad = entidad;
		this.estado = estado;
		this.endSeparator = endSeparator;
	}

	public VOResponse() {
		super();
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * @return the connid
	 */
	public String getConnid() {
		return connid;
	}
	/**
	 * @param connid the connid to set
	 */
	public void setConnid(String connid) {
		this.connid = connid;
	}
	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}
	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	/**
	 * @return the endSeparator
	 */
	public String getEndSeparator() {
		return endSeparator;
	}
	/**
	 * @param endSeparator the endSeparator to set
	 */
	public void setEndSeparator(String endSeparator) {
		this.endSeparator = endSeparator;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the paciente
	 */
	public String getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the codFoc
	 */
	public String getCodFoc() {
		return codFoc;
	}

	/**
	 * @param codFoc the codFoc to set
	 */
	public void setCodFoc(String codFoc) {
		this.codFoc = codFoc;
	}

	/**
	 * @return the entidad
	 */
	public String getEntidad() {
		return entidad;
	}

	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
