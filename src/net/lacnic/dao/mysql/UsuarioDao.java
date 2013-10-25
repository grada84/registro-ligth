package net.lacnic.dao.mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.lacnic.domain.mysql.Usuario;
import net.lacnic.exception.UtilsBusinessException;

public class UsuarioDao {

	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public List<Usuario> obteterUsuarios() {
		Query q = em.createQuery("SELECT u FROM Usuario u");
		return q.getResultList();
	}

	public List<Usuario> obteterUsuariosPorFiltro(String search) {
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.id LIKE :search OR u.nome LIKE :search OR u.email LIKE :search OR u.endLogradouro LIKE :search " + "OR u.endCidade LIKE :search");
		q.setParameter("search", "%" + search + "%");

		return q.getResultList();
	}

	@Deprecated
	public Usuario obteterUsuarioRegitro(String username) {
		Query q = em.createQuery("SELECT us FROM Usuario us WHERE us.id=:username");
		q.setParameter("username", username);
		return (Usuario) q.getSingleResult();
	}
	public Usuario obtenerUsuarioRegitro(String username) {
		Query q = em.createQuery("SELECT us FROM Usuario us WHERE us.id=:username");
		q.setParameter("username", username);
		return (Usuario) q.getSingleResult();
	}

	public Usuario obtenerAdministradordeEstaEntidad(long idEntidad) {
		Query q = em.createQuery("select e.usuarioAdm from Entidad e where e.id = :id");
		q.setParameter("id", idEntidad);
		return (Usuario) q.getSingleResult();
	}

	public Usuario obtenerAdministradordeEstaEntidad(String ownerId) {
		Query q = em.createQuery("select e.usuarioAdm from Entidad e where e.idDocumento = :id");
		q.setParameter("id", ownerId);
		return (Usuario) q.getSingleResult();
	}

	public String obtenerClave(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select u.senha from Usuario u where u.id = :handle");
		q.setParameter("handle", usuario);
		return (String) q.getSingleResult();
	}

	public String obtenerLOCALE(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select u.idioma from Usuario u where u.id = :handle");
		q.setParameter("handle", usuario);
		return (String) q.getSingleResult();
	}

	public String obtenerEmail(String userId) throws UtilsBusinessException {
		Query q = em.createQuery("select u.email from Usuario u where u.id = :userId");
		q.setParameter("userId", userId);
		return (String) q.getSingleResult();
	}

	public Object[] obtenerUserIdIdiomaEmail(String ownerId) throws UtilsBusinessException {
		Query q = em.createQuery("select e.usuarioAdm.id, e.usuarioAdm.idioma, e.usuarioAdm.email from Entidad e where e.idDocumento = :ownerId");
		q.setParameter("ownerId", ownerId);
		return (Object[]) q.getSingleResult();
	}

	public Object[] obtenerContactoMembresiaSoloInfoPadron(String idDocumento) {
		Query q = em.createQuery("select u.id, u.nome, u.email, u.idioma, u.endPais from Usuario u, Entidad e where u.id = e.usuarioMem.id AND e.idDocumento = :idDocumento");
		q.setParameter("idDocumento", idDocumento);
		return (Object[]) q.getSingleResult();
	}
}