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
 * on the table Delegacoes in MySQL
 * 
 */
@Entity
@Table(name="reverse_ds")
public class ReverseDs implements Serializable{
	private static final long serialVersionUID = 5346672073786764154L;

	@EmbeddedId
	private DelegacoesPK delegPK;
	
	@Column(name="zone")
    private String zone;
	
	@Column(name="key_tag")
    private int keyTag;
	
	@Column(name="alg_type")
    private int algType;
	
	@Column(name="dig_type")
    private int digType;
	
	@Column(name="digest")
    private String digest;
	
	@Column(name="status")
    private int status;
    
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @Column(name="last_check_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheckDate;
    
    @Column(name="last_ok_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastOkDate;
    
    @Column(name="expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
        
    public ReverseDs() { }

    
    private DelegacoesPK getDelegPK(){
    	return delegPK;
    }
    
    private void setDelegPK(DelegacoesPK delegPK){
    	this.delegPK = delegPK;
    }
    
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

    public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public int getKeyTag() {
		return keyTag;
	}

	public void setKeyTag(int keyTag) {
		this.keyTag = keyTag;
	}
    
	public int getAlgType() {
		return algType;
	}

	public void setAlgType(int algType) {
		this.algType = algType;
	}
	
	public int getDigType() {
		return digType;
	}

	public void setDigType(int digType) {
		this.digType = digType;
	}
	
	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getLastCheckDate() {
		return lastCheckDate;
	}

	public void setLastCheckDate(Date lastCheckDate) {
		this.lastCheckDate = lastCheckDate;
	}

	public Date getLastOkDate() {
		return lastOkDate;
	}

	public void setLastOkDate(Date lastOkDate) {
		this.lastOkDate = lastOkDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}	
}