package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Implements Java Persistence API,
 * on the table autonomous_system in MySQL
 * 
 */
@Entity
@Table(name="hosts_reverso")
//@AssociationOverrides({
//	@AssociationOverride(name = "hrPK.hostOrder", joinColumns = @JoinColumn(name = "host_order")),
//	@AssociationOverride(name = "hrPK.delegacoesPK", joinColumns = {
//			@JoinColumn(name = "idBloco", referencedColumnName = "id_bloco"),
//			@JoinColumn(name = "idDeleg", referencedColumnName = "id_deleg")})
//	})
public class HostsReverso implements Serializable {
	
	private static final long serialVersionUID = -1348877596247942313L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="id_bloco")
//	private long idBloco;
//	
//	@Id
//	@Column(name="id_deleg")
//	private long idDeleg;
//	
//	@Id
//	@Column(name="host_order")
//	private int hostOrder;
	
	@EmbeddedId
	private HostsReversoPK hrPK;
	
	@Column(name="hostname")
	private String hostname;
	
	@Column(name="data_ultimo_ok")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoOk;
	
	@Column(name="data_ultima_tentativa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaTentativa;
	
	@Column(name="ultima_resposta")
	private int ultimaResposta;
	
//	@OneToOne(optional=true)
//	@JoinColumns({
//		@JoinColumn(name = "hrPK.idBloco", referencedColumnName = "id_bloco"),
//    	@JoinColumn(name = "hrPK.idDeleg", referencedColumnName = "id_deleg")
//	})
	
//	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name = "hrPK.idBloco", referencedColumnName = "id_bloco"),
//    	@JoinColumn(name = "hrPK.idDeleg", referencedColumnName = "id_deleg")
//	})
		
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
//
//	public int getHostOrder() {
//		return hostOrder;
//	}
//
//	public void setHostOrder(int hostOrder) {
//		this.hostOrder = hostOrder;
//	}

	private HostsReversoPK getHrPK(){
	    	return hrPK;
    }
    
    private void setHrPK(HostsReversoPK hrPK){
    	this.hrPK = hrPK;
    }
    
    @Transient
    public DelegacoesPK getDelegacoesPK(){
    	return getHrPK().getDelegacoesPK();
    }
    
    public void setDelegacoesPK(DelegacoesPK del){
    	getHrPK().setDelegacoesPK(del);
    }
    
    @Transient
    public long getIdBloco(){
    	return getHrPK().getIdBloco();
    }
    
    public void setIdBloco(long idBloco){
    	getHrPK().setIdBloco(idBloco);
    }
    
    @Transient
    public long getIdDeleg(){
    	return getHrPK().getIdDeleg();
    }
    
    public void setIdDeleg(long idDeleg){
    	getHrPK().setIdDeleg(idDeleg);
    }
    
    @Transient
    public long getHostOrder(){
    	return getHrPK().getHostOrder();
    }
    
    @Override
	public boolean equals(Object obj) {
		HostsReverso h = (HostsReverso) obj;
		boolean b = (h.hostname.equals(this.hostname) && h.getHostOrder()==this.getHostOrder() && this.getIdBloco()==h.getIdBloco() && this.getIdDeleg()==h.getIdDeleg());
		return b;
	}

	public void setHostOrder(int hostOrder){
    	getHrPK().setHostOrder(hostOrder);
    }
	    
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Date getDataUltimoOk() {
		return dataUltimoOk;
	}

	public void setDataUltimoOk(Date dataUltimoOk) {
		this.dataUltimoOk = dataUltimoOk;
	}

	public Date getDataUltimaTentativa() {
		return dataUltimaTentativa;
	}

	public void setDataUltimaTentativa(Date dataUltimaTentativa) {
		this.dataUltimaTentativa = dataUltimaTentativa;
	}

	public int getUltimaResposta() {
		return ultimaResposta;
	}

	public void setUltimaResposta(int ultimaResposta) {
		this.ultimaResposta = ultimaResposta;
	}
	
	public String obtenerStatus(){
		switch(ultimaResposta){
		case 1000: return "AA";
		case 1100: return "TIMEOUT";
		case 1301: return "UDN (lame - not published)";
		case 1302: return "UH (lame - not published)";
		case 1303: return "FAIL (lame - not published)";
		case 1304: return "QREFUSED (lame - not published)";
		case 1306: return "CREFUSED (lame - not published)";
		case 1308: return "CNAME (lame - not published)";
		case 1309: return "NOT SYNC ZONE";
		default: return null;
		}
	}
}