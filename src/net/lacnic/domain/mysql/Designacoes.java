package net.lacnic.domain.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Implements Java Persistence API,
 * on the table Designacoes in MySQL
 * 
 */
@Entity
@Table(name="designacoes")
public class Designacoes implements Serializable{

	private static final long serialVersionUID = -8996099130409433256L;

//	@Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name="id_bloco")
//    private long id;

//	@Id
//	@ManyToOne
//	@JoinColumn(name="id_bloco")
    @Column(name="id_bloco")
//    private BlocosIP blocoPadre;
    private long blocoPadre;

	@Id
//	@ManyToOne
//	@JoinColumn(name="id_bloco_designado")
    @Column(name="id_bloco_designado")
//    private BlocosIP blocoDesignado;
    private long blocoDesignado;
        
    public Designacoes() {
	}

	public void setBlocoPadre(long blocoPadre) {
		this.blocoPadre = blocoPadre;
	}

	public long getBlocoPadre() {
		return blocoPadre;
	}

	public void setBlocoDesignado(long blocoDesignado) {
		this.blocoDesignado = blocoDesignado;
	}

	public long getBlocoDesignado() {
		return blocoDesignado;
	}

//	public void setBlocoPadre(BlocosIP blocoPadre) {
//		this.blocoPadre = blocoPadre;
//	}
//
//	public BlocosIP getBlocoPadre() {
//		return blocoPadre;
//	}
//
//	public void setBlocoDesignado(BlocosIP blocoDesignado) {
//		this.blocoDesignado = blocoDesignado;
//	}
//
//	public BlocosIP getBlocoDesignado() {
//		return blocoDesignado;
//	}
}