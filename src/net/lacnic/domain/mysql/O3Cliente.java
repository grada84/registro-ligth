package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.lacnic.registro.commons.utils.UtilsOpciones;

/**
 * Implements Java Persistence API, on the table entidade in MySQL
 * 
 */
@Entity
@Table(name = "o3_cliente")
public class O3Cliente implements Serializable {
	private static final long serialVersionUID = -7174243590474178188L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_entidad")
	private long id;

	@Column(name = "id_documento")
	private String idDocumento;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;

	@Column(name = "fecha_renovacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRenovacion;
	
	@Column(name = "miembro")
	private int miembro;
	
	@Column(name = "tipo_cliente")
	private String tipoCliente;

	@Column(name = "pais")
	private String pais;

	@Column(name = "ciudad")
	private String ciudad;

	@OneToOne(mappedBy = "o3Cliente")
	private Entidad entidad;
	
	public O3Cliente() {
	}
	
	public O3Cliente(String tipoCliente) {
		this.miembro = 0;
		this.tipoCliente = tipoCliente;
	}

	public O3Cliente(String tipoCliente, Long idEntidad, String idDocumento, Date dataRenovacao, String pais, int miembro, String nombreOrg) {
		this.tipoCliente = tipoCliente;
		this.id = idEntidad;
		this.idDocumento = idDocumento;
		this.fechaRenovacion = dataRenovacao;
		this.pais = pais;
		this.miembro = miembro;
		this.nombreCliente = nombreOrg;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setFechaRenovacion(Date fechaRenovación) {
		this.fechaRenovacion = fechaRenovación;
	}

	public Date getFechaRenovacion() {
		return fechaRenovacion;
	}

	public void setMiembro(int miembro) {
		this.miembro = miembro;
	}

	public int getMiembro() {
		return miembro;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	
	public boolean esMiembro(){
		if(miembro == UtilsOpciones.SINO_SI) return true;
		return false;
	}
}