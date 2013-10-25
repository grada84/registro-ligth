package net.lacnic.domain.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Implements Java Persistence API,
 * on the table autonomous_system_all_lacnic in MySQL
 * 
 */
@Entity
@Table(name="autonomous_system_all_lacnic")
public class AutonomousSystemAllLACNIC implements Serializable {

	private static final long serialVersionUID = 6908334516768581241L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="autonomous_system_all_lacnic_id")
	private long idASN;
	
	@Column(name="inicio")
	private long inicio;
	
	@Column(name="fin")
	private long fin;

	public void setIdASN(long idASN) {
		this.idASN = idASN;
	}

	public long getIdASN() {
		return idASN;
	}

	public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}
	
	public String getAsn() {
		if(inicio == fin)
			return String.valueOf(inicio);
		else
			return inicio + "-" + fin;
	}
	
}
