package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Implements Java Persistence API, on the table entidade in MySQL
 * 
 */
@Entity
@Table(name = "entidade")
public class Entidad implements Serializable {
	private static final long serialVersionUID = -7174243590474178188L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_entidade")
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "id_documento")
	private String idDocumento;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

	@Column(name = "nome_contato")
	private String nomeContato;

	@Column(name = "tel_ddi")
	private String telDDI;

	@Column(name = "tel_ddd")
	private String telDDD;

	@Column(name = "tel_numero")
	private String telNumero;

	@Column(name = "tel_ramal")
	private String telRamal;

	@Column(name = "end_logradouro")
	private String endLogradouro;

	@Column(name = "end_numero")
	private String endNumero;

	@Column(name = "end_complemento")
	private String endComplemento;

	@Column(name = "end_cidade")
	private String endCidade;

	@Column(name = "end_uf")
	private String endUf;

	@Column(name = "end_pais")
	private String endPais;

	@Column(name = "end_cep")
	private String endCep;

	@ManyToOne(optional = true)
	@JoinColumn(name = "adm_handle", nullable = true)
	private Usuario usuarioAdm;

	@ManyToOne(optional = true)
	@JoinColumn(name = "cob_handle", nullable = true)
	private Usuario usuarioCob;

	@ManyToOne(optional = true)
	@JoinColumn(name = "mem_handle", nullable = true)
	private Usuario usuarioMem;

	@Column(name = "status_tel")
	private int statusTel;

	@Column(name = "status_end")
	private int statusEnd;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();

	@Column(name = "data_ultalt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltalt;

	@Column(name = "data_renovacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRenovacao;

	@Column(name = "tipo_renovacao")
	private long tipoRenovacao;

	@Column(name = "doc_recebido")
	private long docRecebido;

	@Column(name = "recursos")
	private long recursos;

	@Column(name = "data_expiracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExpiracao;

	@Column(name = "org_type")
	private int orgType;

	@Column(name = "epp_login")
	private long eppLogin;

	@Column(name = "epp_status")
	private long eppStatus;

	@Column(name = "epp_password")
	private String eppPassword;

	@Column(name = "epp_ip")
	private String eppIP;

	@Column(name = "epp_clID")
	private long eppCLID;

	@Column(name = "epp_crID")
	private long eppCrID;

	@OneToMany(mappedBy = "entidade")
	private Collection<BlocosIP> blocosIP;

	@OneToMany(mappedBy = "entidade")
	private Collection<AutonomousSystem> Asn;

	@OneToOne
	@JoinColumn(name = "id_entidade")
	private O3Cliente o3Cliente;

	public Entidad() {
	}

	public Entidad(long id, String nome, String idDocumento, String telNumero, String endLogradouro, String endPais, Usuario usuarioAdm, Date dataRenovacao, long recursos, Collection<BlocosIP> blocosIP, Collection<AutonomousSystem> asn) {
		this.id = id;
		this.nome = nome;
		this.idDocumento = idDocumento;
		this.telNumero = telNumero;
		this.endLogradouro = endLogradouro;
		this.endPais = endPais;
		this.usuarioAdm = usuarioAdm;
		this.dataRenovacao = dataRenovacao;
		this.recursos = recursos;
		this.blocosIP = blocosIP;
		Asn = asn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getTelDDI() {
		return telDDI;
	}

	public void setTelDDI(String telDDI) {
		this.telDDI = telDDI;
	}

	public String getTelDDD() {
		return telDDD;
	}

	public void setTelDDD(String telDDD) {
		this.telDDD = telDDD;
	}

	public String getTelNumero() {
		return telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getTelRamal() {
		return telRamal;
	}

	public void setTelRamal(String telRamal) {
		this.telRamal = telRamal;
	}

	public String getEndLogradouro() {
		return endLogradouro;
	}

	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
	}

	public String getEndNumero() {
		return endNumero;
	}

	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}

	public String getEndComplemento() {
		return endComplemento;
	}

	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

	public String getEndCidade() {
		return endCidade;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}

	public String getEndUf() {
		return endUf;
	}

	public void setEndUf(String endUf) {
		this.endUf = endUf;
	}

	public String getEndPais() {
		return endPais;
	}

	public void setEndPais(String endPais) {
		this.endPais = endPais;
	}

	public String getEndCep() {
		return endCep;
	}

	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}

	public void setUsuarioAdm(Usuario usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public Usuario getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioCob(Usuario usuarioCob) {
		this.usuarioCob = usuarioCob;
	}

	public Usuario getUsuarioCob() {
		return usuarioCob;
	}

	public void setUsuarioMem(Usuario usuarioMem) {
		this.usuarioMem = usuarioMem;
	}

	public Usuario getUsuarioMem() {
		return usuarioMem;
	}

	public int getStatusTel() {
		return statusTel;
	}

	public void setStatusTel(int statusTel) {
		this.statusTel = statusTel;
	}

	public int getStatusEnd() {
		return statusEnd;
	}

	public void setStatusEnd(int statusEnd) {
		this.statusEnd = statusEnd;
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

	public Date getDataRenovacao() {
		return dataRenovacao;
	}

	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}

	public long getTipoRenovacao() {
		return tipoRenovacao;
	}

	public void setTipoRenovacao(long tipoRenovacao) {
		this.tipoRenovacao = tipoRenovacao;
	}

	public long getDocRecebido() {
		return docRecebido;
	}

	public void setDocRecebido(long docRecebido) {
		this.docRecebido = docRecebido;
	}

	public long getRecursos() {
		return recursos;
	}

	public void setRecursos(long recursos) {
		this.recursos = recursos;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public long getEppLogin() {
		return eppLogin;
	}

	public void setEppLogin(long eppLogin) {
		this.eppLogin = eppLogin;
	}

	public long getEppStatus() {
		return eppStatus;
	}

	public void setEppStatus(long eppStatus) {
		this.eppStatus = eppStatus;
	}

	public String getEppPassword() {
		return eppPassword;
	}

	public void setEppPassword(String eppPassword) {
		this.eppPassword = eppPassword;
	}

	public String getEppIP() {
		return eppIP;
	}

	public void setEppIP(String eppIP) {
		this.eppIP = eppIP;
	}

	public long getEppCLID() {
		return eppCLID;
	}

	public void setEppCLID(long eppCIID) {
		this.eppCLID = eppCIID;
	}

	public long getEppCrID() {
		return eppCrID;
	}

	public void setEppCrID(long eppCrID) {
		this.eppCrID = eppCrID;
	}

	public Collection<BlocosIP> getBlocosIP() {
		return blocosIP;
	}

	public void setBlocosIP(Collection<BlocosIP> blocosIP) {
		this.blocosIP = blocosIP;
	}

	public void setAsn(Collection<AutonomousSystem> asn) {
		Asn = asn;
	}

	public Collection<AutonomousSystem> getAsn() {
		return Asn;
	}

	public O3Cliente getO3Cliente() {
		if (o3Cliente == null)
			return new O3Cliente("none");
		else
			return o3Cliente;
	}

	public void setO3Cliente(O3Cliente o3Cliente) {
		this.o3Cliente = o3Cliente;
	}

	@Override
	public String toString() {
		return id + " - " + nome + " - " + endCidade + "," + endPais;
	}


}