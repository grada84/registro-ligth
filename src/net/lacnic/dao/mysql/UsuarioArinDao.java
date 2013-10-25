package net.lacnic.dao.mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.lacnic.domain.mysql.UsuarioArin;

public class UsuarioArinDao {


	private EntityManager em;

	public UsuarioArinDao(EntityManager em) {
		this.em = em;
	}
	
	public List<UsuarioArin> obteterUsuarios() {
		Query q = em.createQuery("SELECT u FROM UsuarioArin u");
		return q.getResultList();
	}
	
	public List<UsuarioArin> obteterUsuariosPorFiltro(String search) {
		Query q = em.createQuery("SELECT u FROM UsuarioArin u WHERE u.id LIKE :search OR u.nome LIKE :search OR u.email LIKE :search OR u.endLogradouro LIKE :search " +
				"OR u.endPais LIKE :search");
		q.setParameter("search", "%"+search+"%");
		
		return q.getResultList();
	}
	
	
	@Deprecated
	public UsuarioArin obteterUsuarioRegitro(String username) {
		Query q = em.createQuery("SELECT us FROM UsuarioArin us WHERE us.id=:username");
		q.setParameter("username", username);
		List<UsuarioArin> res = q.getResultList();
		if(res.size() == 1){
			return (UsuarioArin) q.getSingleResult();
		} else {
			return null;
		}
	}
	
	public UsuarioArin obtenerUsuarioRegitro(String username) {
		Query q = em.createQuery("SELECT us FROM UsuarioArin us WHERE us.id=:username");
		q.setParameter("username", username);
		List<UsuarioArin> res = q.getResultList();
		if(res.size() == 1){
			return (UsuarioArin) q.getSingleResult();
		} else {
			return null;
		}
	}
	
	public String obtenerAdministradordeEstaEntidad(long idEntidad) {
		Query q = em.createQuery("select e.usuarioAdm from EntidadArin e where e.id = :id");
		q.setParameter("id", idEntidad);
		return (String) q.getSingleResult();
	}
	
	public String obtenerAdministradordeEstaEntidad(String ownerId) {
		Query q = em.createQuery("select e.usuarioAdm from EntidadArin e where e.idDocumento = :id");
		q.setParameter("id", ownerId);
		return (String) q.getSingleResult();
	}

}