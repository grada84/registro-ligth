package net.lacnic.data;

import java.io.Serializable;
import java.util.Date;

import net.lacnic.domain.mysql.Usuario;

public class UsuarioData implements Serializable{
	
	private static final long serialVersionUID = 1675671317645684962L;

	private String handleUsuario;
	
	private String nome;

	private String senha;

	private String lembrete;

	private String email;

	private String telDDI;

	private String telDDD;

	private String telNumero;

	private String telRamal;

	private String endLogradouro;

	private String endNumero;

	private String endComplemento;

	private String endCidade;

	private String endUf;

	private String endPais;

	private String endCep;

	private Date dataCadastro;

	private Date dataUltalt;

	private String priNome;

	private String ultNome;

	private int propriedades;

	private String idioma;

	private int idCertificate;

	private int certificateOnly;

	private long eppCLID;

	private long eppCrID;
	
//	@OneToMany(mappedBy = "usuario")
//	private Collection<Entidad> entidad;
//	
//	@OneToMany(mappedBy = "usuario")
//	private Collection<BlocosIP> bloques;
	
	public UsuarioData(){ }

	public UsuarioData(Usuario usuario) {
		this.handleUsuario = usuario.getId();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
		this.lembrete = usuario.getLembrete();
		this.email = usuario.getEmail();
		this.telDDI = usuario.getTelDDI();
		this.telDDD = usuario.getTelDDD();
		this.telNumero = usuario.getTelNumero();
		this.telRamal = usuario.getTelRamal();
		this.endLogradouro = usuario.getEndLogradouro();
		this.endNumero = usuario.getEndNumero();
		this.endComplemento = usuario.getEndComplemento();
		this.endCidade = usuario.getEndCidade();
		this.endUf = usuario.getEndUf();
		this.endPais = usuario.getEndPais();
		this.endCep = usuario.getEndCep();
		this.dataCadastro = usuario.getDataCadastro();
		this.dataUltalt = usuario.getDataUltalt();
		this.priNome = usuario.getPriNome();
		this.ultNome = usuario.getUltNome();
		this.propriedades = usuario.getPropriedades();
		this.idioma = usuario.getIdioma();
		this.idCertificate = usuario.getIdCertificate();
		this.certificateOnly = usuario.getCertificateOnly();
		this.eppCLID = usuario.getEppCLID();
		this.eppCrID = usuario.getEppCrID();		
	}

	public void setHandleUsuario(String handleUsuario) {
		this.handleUsuario = handleUsuario;
	}
	public String getHandleUsuario() {
		return handleUsuario;
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
//	public void setEntidad(Collection<Entidad> enti) {
//		entidad = enti;
//	}
//
//	public Collection<Entidad> getEntidad() {
//		return entidad;
//	}
	public void setPropriedades(int propriedades) {
		this.propriedades = propriedades;
	}
	public int getPropriedades() {
		return propriedades;
	}
//	public void setBloques(Collection<BlocosIP> bloques) {
//		this.bloques = bloques;
//	}
//
//	public Collection<BlocosIP> getBloques() {
//		return bloques;
//	}	
}
