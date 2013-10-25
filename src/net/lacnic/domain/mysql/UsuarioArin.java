package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Implements Java Persistence API,
 * on the table usuario_arin in MySQL
 * 
 */
@Entity
@Table(name="usuario_arin")
public class UsuarioArin implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4778051094838476755L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="handle")
	private String id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefone")
	private String telNumero;
	
	@Column(name="endereco")
	private String endLogradouro;
	
	@Column(name="pais")
	private String endPais;
	
	@Transient
//	@OneToMany(mappedBy = "usuarioAdm")
	private Collection<Entidad> entidad;
	
	@Transient
//	@OneToMany(mappedBy = "usuarioAdm")
	private Collection<BlocosIP> bloques;

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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getTelNumero() {
		return telNumero;
	}

	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
	}

	public String getEndLogradouro() {
		return endLogradouro;
	}

	public void setEndPais(String endPais) {
		this.endPais = endPais;
	}

	public String getEndPais() {
		return endPais;
	}

	public void setEntidad(Collection<Entidad> enti) {
		entidad = enti;
	}

	public Collection<Entidad> getEntidad() {
		return entidad;
	}

	public void setBloques(Collection<BlocosIP> bloques) {
		this.bloques = bloques;
	}

	public Collection<BlocosIP> getBloques() {
		return bloques;
	}

	@Override
	public String toString() {
		return id + " - " + nome + " - " + endPais;
	}	
}
