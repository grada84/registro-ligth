package net.lacnic.domain.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class HostsReversoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7427124061235288903L;
	/**
	 * 
	 */
	@Column(name = "host_order")
	private Integer hostOrder;
	
//	@ManyToOne
	private DelegacoesPK delegacoesPK;

//	@Column(name = "id_bloco")
//	private long idBloco;
//	
//	@Column(name = "id_deleg")
//	private  long idDeleg;
	
	
	

	public DelegacoesPK getDelegacoesPK() {
		return delegacoesPK;
	}

	public void setDelegacoesPK(DelegacoesPK delegacoesPK) {
		this.delegacoesPK = delegacoesPK;
	}

	@Transient
	public long getIdBloco() {
		return getDelegacoesPK().getIdBloco();
	}

	public void setIdBloco(long idBloco) {
		getDelegacoesPK().setIdBloco(idBloco);
	}

	@Transient
	public long getIdDeleg() {
		return getDelegacoesPK().getIdDeleg();
	}

	public void setIdDeleg(long idDeleg) {
		getDelegacoesPK().setIdDeleg(idDeleg);
	}
	
//	public long getIdBloco() {
//		return idBloco;
//	}
//
//	public void setIdBloco(long idBloco) {
//		this.idBloco = idBloco;
//	}
//
//	public long getIdDeleg() {
//		return idDeleg;
//	}
//
//	public void setIdDeleg(long idDeleg) {
//		this.idDeleg = idDeleg;
//	}

	public void setHostOrder(int hostOrder) {
		this.hostOrder = hostOrder;
	}
	
	public int getHostOrder() {
		return hostOrder;
	}
	
//	@Override
//	public int hashCode(){
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((hostOrder == null) ? 0 : hostOrder.hashCode());
//		result = prime * result + ((delegacoesPK == null) ? 0 : delegacoesPK.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj){
//		if(this == obj) return true;
//		if(obj == null) return false;
//		if(getClass() != obj.getClass()) return false;
//		final HostsReversoPK otro = (HostsReversoPK) obj;
//		if(hostOrder == null){
//			if(otro.hostOrder != null) return false;
//		} else if(!hostOrder.equals(otro.hostOrder)) return false;
//		if(delegacoesPK == null){
//			if(otro.delegacoesPK != null) return false;
//		} else if(!delegacoesPK.equals(otro.delegacoesPK)) return false;
//		return true;
//	}
	
	
}
