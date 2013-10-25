package net.lacnic.data;

import java.io.Serializable;
import java.util.Date;

public class BlocoNivel implements Serializable{
	private int nivel;
	private String recurso;
	public BlocoNivel() {}
	public BlocoNivel(int nivel, String recurso, String ownerId, String nombre,
			Date fechaIngreso, long idBloco) {
		super();
		this.nivel = nivel;
		this.recurso = recurso;
		this.ownerId = ownerId;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.idBloco = idBloco;
	}
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	private String ownerId;
	private String nombre;
	
	private Date fechaIngreso;
	public String getNombre() {
		return nombre;
	}
	
	public long idBloco;
	public long getIdBloco() {
		return idBloco;
	}
	public void setIdBloco(long idBloco) {
		this.idBloco = idBloco;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
