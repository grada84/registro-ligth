package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Implements Java Persistence API,
 * on the table usuario in MySQL
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 5100002759026750331L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="handle_usuario")
	private String id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="lembrete")
	private String lembrete;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tel_ddi")
	private String telDDI;
	
	@Column(name="tel_ddd")
	private String telDDD;
	
	@Column(name="tel_numero")
	private String telNumero;
	
	@Column(name="tel_ramal")
	private String telRamal;
	
	@Column(name="end_logradouro")
	private String endLogradouro;
	
	@Column(name="end_numero")
	private String endNumero;
	
	@Column(name="end_complemento")
	private String endComplemento;
	
	@Column(name="end_cidade")
	private String endCidade;
	
	@Column(name="end_uf")
	private String endUf;
	
	@Column(name="end_pais")
	private String endPais;
	
	@Column(name="end_cep")
	private String endCep;
	
	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	@Column(name="data_ultalt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltalt;
	
	@Column(name="pri_nome")
	private String priNome;
	
	@Column(name="ult_nome")
	private String ultNome;
	
	@Column(name="propriedades")
	private int propriedades;
	
	@Column(name="idioma")
	private String idioma;
	
	@Column(name="id_certificate")
	private int idCertificate;
	
	@Column(name="certificateOnly")
	private int certificateOnly;
	
	@Column(name="epp_clID")
	private long eppCLID;
	
	@Column(name="epp_crID")
	private long eppCrID;
	
	@OneToMany(mappedBy = "usuarioAdm")
	private Collection<Entidad> entidad;
	
	@OneToMany(mappedBy = "usuarioAdm")
	private Collection<BlocosIP> bloques;

    public Usuario() { }
	
	public Usuario(String id, String nome, String email, String telNumero,
			String endLogradouro, String endPais) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telNumero = telNumero;
		this.endLogradouro = endLogradouro;
		this.endPais = endPais;
	}
	
	public Usuario(String handle, String nombre, String email, String idioma, String pais){
		this.id = handle;
		this.nome = nombre;
		this.email = email;
		this.idioma = idioma;
		this.endPais = pais;
	}
	
	
	public void setId(String handleUsuario) {
		this.id = handleUsuario;
	}

	public String getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setLembrete(String lembrete) {
		this.lembrete = lembrete;
	}

	public String getLembrete() {
		return lembrete;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setTelDDI(String telDDI) {
		this.telDDI = telDDI;
	}

	public String getTelDDI() {
		return telDDI;
	}

	public void setTelDDD(String telDDD) {
		this.telDDD = telDDD;
	}

	public String getTelDDD() {
		return telDDD;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getTelNumero() {
		return telNumero;
	}

	public void setTelRamal(String telRamal) {
		this.telRamal = telRamal;
	}

	public String getTelRamal() {
		return telRamal;
	}

	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
	}

	public String getEndLogradouro() {
		return endLogradouro;
	}

	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}

	public String getEndNumero() {
		return endNumero;
	}

	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

	public String getEndComplemento() {
		return endComplemento;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}

	public String getEndCidade() {
		return endCidade;
	}

	public void setEndUf(String endUf) {
		this.endUf = endUf;
	}

	public String getEndUf() {
		return endUf;
	}

	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}

	public String getEndCep() {
		return endCep;
	}

	public void setPriNome(String priNome) {
		this.priNome = priNome;
	}

	public String getPriNome() {
		return priNome;
	}

	public void setDataUltalt(Date dataUltalt) {
		this.dataUltalt = dataUltalt;
	}

	public Date getDataUltalt() {
		return dataUltalt;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setEndPais(String endPais) {
		this.endPais = endPais;
	}

	public String getEndPais() {
		return endPais;
	}

	public void setUltNome(String ultNome) {
		this.ultNome = ultNome;
	}

	public String getUltNome() {
		return ultNome;
	}

	public void setCertificateOnly(int certificateOnly) {
		this.certificateOnly = certificateOnly;
	}

	public int getCertificateOnly() {
		return certificateOnly;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setEppCLID(long eppCLID) {
		this.eppCLID = eppCLID;
	}

	public long getEppCLID() {
		return eppCLID;
	}

	public void setEppCrID(long eppCrID) {
		this.eppCrID = eppCrID;
	}

	public long getEppCrID() {
		return eppCrID;
	}

	public void setIdCertificate(int idCertificate) {
		this.idCertificate = idCertificate;
	}

	public int getIdCertificate() {
		return idCertificate;
	}

	public void setEntidad(Collection<Entidad> enti) {
		entidad = enti;
	}

	public Collection<Entidad> getEntidad() {
		return entidad;
	}

	public void setPropriedades(int propriedades) {
		this.propriedades = propriedades;
	}

	public int getPropriedades() {
		return propriedades;
	}

	public void setBloques(Collection<BlocosIP> bloques) {
		this.bloques = bloques;
	}

	public Collection<BlocosIP> getBloques() {
		return bloques;
	}

	@Override
	public String toString() {
		return id + " - " + nome + " - " + endCidade + "," + endPais;
	}	
}
