package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class BlocosIP implements Serializable{

	private static final long serialVersionUID = 7273078995553056568L;

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

    @ManyToOne
	@JoinColumn(name = "adm_handle")
	private Usuario usuarioAdm;  
    
    @ManyToOne
	@JoinColumn(name = "sec_handle")
	private Usuario usuarioSec;
    
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
    private Entidad entidade;
    
    @OneToMany(mappedBy = "delegPK.idBloco")
    private List<Delegacoes> delegacoes;
    
//    @OneToMany(mappedBy = "blocoPadre")
//	private Collection<Designacoes> blocosIPPadre;
//    
//    @OneToMany(mappedBy = "blocoDesignado")
//	private Collection<Designacoes> blocosIPDesignados;
    
	public BlocosIP() { }
    
	public BlocosIP(long id, int version, BigInteger ipIncial, BigInteger ipFinal, long asn, Date dataCadastro, Date dataUltalt, long status, long eppCLDD, long eppCrIDD) {
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
 
	//la de antes
	public BlocosIP(int version, BigInteger ipIncial, BigInteger ipFinal, long id) {
		this.version = version;
		this.ipIncial = ipIncial;
		this.ipFinal = ipFinal;
		this.id = id;
	}
	
	public BlocosIP(int version, BigInteger ipIncial, BigInteger ipFinal, long id, Date dataCadastro, Date dataUltAlt, long status) {
		this.version = version;
		this.ipIncial = ipIncial;
		this.ipFinal = ipFinal;
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.dataUltalt = dataUltAlt;
		this.status = status;
	}

	
	public BlocosIP(long id, int version, BigInteger ipIncial,
			BigInteger ipFinal, long asn, Usuario usuarioAdm,
			Usuario usuarioSec, Date dataCadastro, Date dataUltalt,
			long status, long eppCLDD, long eppCrIDD, Entidad entidade) {
		super();
		this.id = id;
		this.version = version;
		this.ipIncial = ipIncial;
		this.ipFinal = ipFinal;
		this.asn = asn;
		this.usuarioAdm = usuarioAdm;
		this.usuarioSec = usuarioSec;
		this.dataCadastro = dataCadastro;
		this.dataUltalt = dataUltalt;
		this.status = status;
		this.eppCLDD = eppCLDD;
		this.eppCrIDD = eppCrIDD;
		this.entidade = entidade;
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
	
	public void setUsuarioSec(Usuario usuarioSec) {
		this.usuarioSec = usuarioSec;
	}

	public Usuario getUsuarioSec() {
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

	public Entidad getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidad entidade) {
		this.entidade = entidade;
	}

	public void setUsuarioAdm(Usuario usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public Usuario getUsuarioAdm() {
		return usuarioAdm;
	}

//	public void setBlocosIPPadre(Collection<Designacoes> blocosIPPadre) {
//		this.blocosIPPadre = blocosIPPadre;
//	}
//
//	public Collection<Designacoes> getBlocosIPPadre() {
//		return blocosIPPadre;
//	}
//
//	public void setBlocosIPDesignados(Collection<Designacoes> blocosIPDesignados) {
//		this.blocosIPDesignados = blocosIPDesignados;
//	}
//
//	public Collection<Designacoes> getBlocosIPDesignados() {
//		return blocosIPDesignados;
//	}   
    
}