package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class AutonomousSystem implements Serializable {

	private static final long serialVersionUID = 6908334516768581241L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="asn")
	private long id;
		
//    @Column(name="adm_handle")
//    private String admHandle;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "adm_handle", nullable = true)
	private Usuario usuarioAdm;
    
//	@Column(name="sec_handle")
//	private String secHandle;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "sec_handle", nullable = true)
	private Usuario usuarioSec;
	
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
	   
	@ManyToOne
    @JoinColumn(name="id_entidade")
    private Entidad entidade;

	public AutonomousSystem() { }
	
	public AutonomousSystem(long id, Usuario usuarioAdm, Usuario usuarioSec, String keyId, Date dataCadastro, String nextInvoiceYear,
			Date dataUltalt, long eppClID, long eppCrID, Entidad entidade) {
		this.id = id;
		this.usuarioAdm = usuarioAdm;
		this.usuarioSec = usuarioSec;
		this.keyId = keyId;
		this.dataCadastro = dataCadastro;
		this.nextInvoiceYear = nextInvoiceYear;
		this.dataUltalt = dataUltalt;
		this.eppClID = eppClID;
		this.eppCrID = eppCrID;
		this.entidade = entidade;
	}
	
//	public void setAdmHandle(String admHandle) {
//		this.admHandle = admHandle;
//	}
//
//	public String getAdmHandle() {
//		return admHandle;
//	}
	
	public void setUsuarioAdm(Usuario usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public Usuario getUsuarioAdm() {
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
	
	public void setUsuarioSec(Usuario usuarioSec) {
		this.usuarioSec = usuarioSec;
	}

	public Usuario getUsuarioSec() {
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

	public void setEntidade(Entidad entidade) {
		this.entidade = entidade;
	}

	public Entidad getEntidade() {
		return entidade;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
