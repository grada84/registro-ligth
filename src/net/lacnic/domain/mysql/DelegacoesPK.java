package net.lacnic.domain.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DelegacoesPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1821247159141305053L;

	@Column(name = "id_bloco")
	private Long idBloco;
	
	@Column(name = "id_deleg")
	private Long idDeleg;
	
	public long getIdDeleg() {
		return idDeleg;
	}
	public long getIdBloco() {
		return idBloco;
	}
	public void setIdBloco(long idBloco) {
		this.idBloco = idBloco;
	}
	public void setIdDeleg(long idDeleg) {
		this.idDeleg = idDeleg;
	}	
}
