package net.lacnic.domain.mysql;

import java.io.Serializable;
import java.math.BigInteger;
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
 * on the table Delegacoes in MySQL
 * 
 */
@Entity
@Table(name="delegacoes")
public class Delegacoes implements Serializable{


	private static final long serialVersionUID = -8001085870270430244L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name="id_bloco")
//    private long idBloco;
//
//	@Id
//	@Column(name="id_deleg")
//    private long idDeleg;
	
	@EmbeddedId
//	@Id
	private DelegacoesPK delegPK;
	
//	@OneToMany(mappedBy = "hrPK.delegacoesPK")
//    @JoinColumns({
//    	@JoinColumn(name = "idBloco", referencedColumnName = "id_bloco"),
//    	@JoinColumn(name = "idDeleg", referencedColumnName = "id_deleg")
//    })
//    private List<HostsReverso> hostsReversos;
    
    @Column(name="ip_inicial")
    private BigInteger ipInicial;
    
    @Column(name="ip_final")
    private BigInteger ipFinal;
    
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @Column(name="data_ultalt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltalt;
        
    public Delegacoes() {
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
    
    private DelegacoesPK getDelegPK(){
    	return delegPK;
    }
    
    private void setDelegPK(DelegacoesPK delegPK){
    	this.delegPK = delegPK;
    }
    
//    @Transient
//    public BlocosIP getBlocoPadre(){
//    	return getDelegPK().getIdBloco();
//    }
//    
//    public void setBlocoPadre(BlocosIP b){
//    	getDelegPK().setBlocoPadre(b);
//    }
    
    @Transient
    public long getIdBloco(){
    	return getDelegPK().getIdBloco();
    }
    
    public void setIdBloco(long idBloco){
    	getDelegPK().setIdBloco(idBloco);
    }
    
    @Transient
    public long getIdDeleg(){
    	return getDelegPK().getIdDeleg();
    }
    
    public void setIdDeleg(long idDeleg){
    	getDelegPK().setIdDeleg(idDeleg);
    }

	public BigInteger getIpInicial() {
		return ipInicial;
	}

	public void setIpInicial(BigInteger ipIncial) {
		this.ipInicial = ipIncial;
	}

	public BigInteger getIpFinal() {
		return ipFinal;
	}

	public void setIpFinal(BigInteger ipFinal) {
		this.ipFinal = ipFinal;
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
	
//	@Override
//	public int hashCode(){
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((hostsReversos == null) ? 0 : hostsReversos.hashCode());
//		result = prime * result + ((delegPK == null) ? 0 : delegPK.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj){
//		if(this == obj) return true;
//		if(obj == null) return false;
//		if(getClass() != obj.getClass()) return false;
//		final Delegacoes otro = (Delegacoes) obj;
//		if(hostsReversos == null){
//			if(otro.hostsReversos != null) return false;
//		} else if(!hostsReversos.equals(otro.hostsReversos)) return false;
//		if(delegPK == null){
//			if(otro.delegPK != null) return false;
//		} else if(!delegPK.equals(otro.delegPK)) return false;
//		return true;
//	}

	
}
