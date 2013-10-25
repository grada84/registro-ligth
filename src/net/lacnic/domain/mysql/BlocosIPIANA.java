package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.ripe.ipresource.IpResource;

/**
 * Implements Java Persistence API, on the table blocosip_iana in MySQL
 * 
 */

@Entity
@Table(name = "blocosip_iana")
public class BlocosIPIANA implements Serializable {

	private static final long serialVersionUID = 2241109409607388096L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_bloco_iana")
	private long id;

	@Column(name = "version")
	private int version;

	@Column(name = "ip_inicial")
	private BigInteger ipInicial;

	@Column(name = "ip_final")
	private BigInteger ipFinal;

	@Column(name = "bloque")
	private String bloque;

	@Column(name = "organizacion")
	private String organizacion;

	public BlocosIPIANA() {
	}

	public BlocosIPIANA(String bloque, String org) {
		IpResource ipv4 = IpResource.parse(bloque);
		setIpInicial(ipv4.getStart().getValue());
		setIpFinal(ipv4.getEnd().getValue());
		setVersion(4);
		setOrganizacion(org.trim());
		setBloque(bloque.trim());
	}

	public void cargarBloques() throws Exception {

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

	public BigInteger getIpInicial() {
		return ipInicial;
	}

	public void setIpInicial(BigInteger ipInicial) {
		this.ipInicial = ipInicial;
	}

	public BigInteger getIpFinal() {
		return ipFinal;
	}

	public void setIpFinal(BigInteger ipFinal) {
		this.ipFinal = ipFinal;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getBloque() {
		return bloque;
	}

}