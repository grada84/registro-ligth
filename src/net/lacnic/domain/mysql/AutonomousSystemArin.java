package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Implements Java Persistence API,
 * on the table autonomous_system in MySQL
 * 
 */
@Entity
@Table(name="autonomous_system")
public class AutonomousSystemArin implements Serializable {

	
	private static final long serialVersionUID = -3878282495951204990L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="asn")
	private long id;
		
    @Column(name="adm_handle")
    private String usuarioAdm;
	
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "adm_handle", nullable = true)
//	private UsuarioArin usuarioAdm;
    
	@Column(name="sec_handle")
	private String usuarioSec;
	
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "sec_handle", nullable = true)
//	private UsuarioArin usuarioSec;
	
	@Column(name="key_id")
	private String keyId;
	
	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Column(name="next_invoice_year")
	private String nextInvoiceYear;
	
	@Column(name="data_ultalt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltalt;
	
	@Column(name="epp_clID")
	private long eppClID;
	
	@Column(name="epp_crID")
	private long eppCrID;
	
	@Column(name="id_entidade")
	private long idEntidade;
	   
//	@ManyToOne
//    @JoinColumn(name="id_entidade")
//    private EntidadArin entidade;


//	public void setAdmHandle(String admHandle) {
//		this.admHandle = admHandle;
//	}
//
//	public String getAdmHandle() {
//		return admHandle;
//	}
	
	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getKeyId() {
		return keyId;
	}

//	public void setSecHandle(String secHandle) {
//		this.secHandle = secHandle;
//	}
//
//	public String getSecHandle() {
//		return secHandle;
//	}
	
	public void setUsuarioSec(String usuarioSec) {
		this.usuarioSec = usuarioSec;
	}

	public String getUsuarioSec() {
		return usuarioSec;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setNextInvoiceYear(String nextInvoiceYear) {
		this.nextInvoiceYear = nextInvoiceYear;
	}

	public String getNextInvoiceYear() {
		return nextInvoiceYear;
	}

	public void setDataUltalt(Date dataUltalt) {
		this.dataUltalt = dataUltalt;
	}

	public Date getDataUltalt() {
		return dataUltalt;
	}

	public void setEppClID(long eppClID) {
		this.eppClID = eppClID;
	}

	public long getEppClID() {
		return eppClID;
	}

	public void setEppCrID(long eppCrID) {
		this.eppCrID = eppCrID;
	}

	public long getEppCrID() {
		return eppCrID;
	}

//	public void setEntidade(EntidadArin entidade) {
//		this.entidade = entidade;
//	}
//
//	public EntidadArin getEntidade() {
//		return entidade;
//	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public long getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(long idEntidade) {
		this.idEntidade = idEntidade;
	}
}
