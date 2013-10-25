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
 * Implements Java Persistence API, on the table entidade_arin in MySQL
 * 
 */
@Entity
@Table(name = "entidade_arin")
public class EntidadArin implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7787276045214945941L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_entidade")
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "id_documento")
	private String idDocumento;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "pais")
	private String pais;

	@Column(name = "telefone")
	private String tel;
	
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "adm_handle", nullable = true)
//	private UsuarioArin usuarioAdm;
	
	@Column(name = "adm_handle")
	private String usuarioAdm;

	@Column(name = "data_renovacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRenovacao;

	@Column(name = "recursos")
	private long recursos;

//	@OneToMany(mappedBy = "entidade_arin")
//	@Transient
//	private Collection<BlocosIPArin> blocosIP;

//	@OneToMany(mappedBy = "entidade_arin")
//	@Transient
//	private Collection<AutonomousSystemArin> Asn;

	public EntidadArin() {
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefone() {
		return tel;
	}

	public void setTelefone(String tel) {
		this.tel = tel;
	}
	
	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}

	public Date getDataRenovacao() {
		return dataRenovacao;
	}

	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}

	public long getRecursos() {
		return recursos;
	}

	public void setRecursos(long recursos) {
		this.recursos = recursos;
	}

	

//	public Collection<BlocosIPArin> getBlocosIPArin() {
//		return blocosIP;
//	}
//
//	public void setBlocosIPArin(Collection<BlocosIPArin> blocosIP) {
//		this.blocosIP = blocosIP;
//	}
//
//	public void setAsn(Collection<AutonomousSystemArin> asn) {
//		Asn = asn;
//	}
//
//	public Collection<AutonomousSystemArin> getAsn() {
//		return Asn;
//	}
	
	
	@Override
	public String toString() {
		return id + " - " + nome + " - " + pais;
	}
	
}