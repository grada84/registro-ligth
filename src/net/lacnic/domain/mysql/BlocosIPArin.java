package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.math.BigInteger;
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
 * on the table blocosip in MySQL
 * 
 */

@Entity
@Table(name="blocosip")
public class BlocosIPArin implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5033633881700466339L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_bloco")
    private long id;

    @Column(name="version")
    private int version;
    
    @Column(name="ip_inicial")
    private BigInteger ipIncial;
    
    @Column(name="ip_final")
    private BigInteger ipFinal;
    
    @Column(name="asn")
    private long asn;

//    @ManyToOne
//	@JoinColumn(name = "adm_handle", nullable = true)
//	private UsuarioArin usuarioAdm;  
    
	@Column(name = "adm_handle")
	private String usuarioAdm;  
    
//    @ManyToOne
//	@JoinColumn(name = "sec_handle", nullable = true)
//	private UsuarioArin usuarioSec;
	
	@Column(name = "sec_handle")
	private String usuarioSec;
    
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @Column(name="data_ultalt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltalt;
    
    @Column(name="status")
    private long status;
    
    @Column(name="epp_clID")
    private long eppCLDD;
    
    @Column(name="epp_crID")
    private long eppCrIDD;
    
    
    @ManyToOne
    @JoinColumn(name="id_entidade")
    private EntidadArin entidade;
    
    
    public BlocosIPArin() { }
    
	public BlocosIPArin(long id, int version, BigInteger ipIncial, BigInteger ipFinal, long asn, Date dataCadastro, Date dataUltalt, long status, long eppCLDD, long eppCrIDD) {
		this.id = id;
		this.version = version;
		this.ipIncial = ipIncial;
		this.ipFinal = ipFinal;
		this.asn = asn;
		this.dataCadastro = dataCadastro;
		this.dataUltalt = dataUltalt;
		this.status = status;
		this.eppCLDD = eppCLDD;
		this.eppCrIDD = eppCrIDD;
	}
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public BigInteger getIpIncial() {
		return ipIncial;
	}

	public void setIpIncial(BigInteger ipIncial) {
		this.ipIncial = ipIncial;
	}

	public BigInteger getIpFinal() {
		return ipFinal;
	}

	public void setIpFinal(BigInteger ipFinal) {
		this.ipFinal = ipFinal;
	}

	public long getAsn() {
		return asn;
	}

	public void setAsn(long asn) {
		this.asn = asn;
	}
	
	public void setUsuarioSec(String usuarioSec) {
		this.usuarioSec = usuarioSec;
	}

	public String getUsuarioSec() {
		return usuarioSec;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataUltalt() {
		return dataUltalt;
	}

	public void setDataUltalt(Date dataUltalt) {
		this.dataUltalt = dataUltalt;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getEppCLDD() {
		return eppCLDD;
	}

	public void setEppCLDD(long eppCLDD) {
		this.eppCLDD = eppCLDD;
	}

	public long getEppCrIDD() {
		return eppCrIDD;
	}

	public void setEppCrIDD(long eppCrIDD) {
		this.eppCrIDD = eppCrIDD;
	}

	public EntidadArin getEntidade() {
		return entidade;
	}

	public void setEntidade(EntidadArin entidade) {
		this.entidade = entidade;
	}

	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}
 
    
}