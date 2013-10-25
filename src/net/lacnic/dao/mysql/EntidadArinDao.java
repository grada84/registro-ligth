package net.lacnic.dao.mysql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.lacnic.domain.mysql.Entidad;
import net.lacnic.domain.mysql.EntidadArin;
import net.lacnic.exception.UtilsBusinessException;
import net.lacnic.registro.commons.utils.UtilsFechas;
import net.lacnic.registro.commons.utils.UtilsFormato;
import net.lacnic.registro.commons.utils.UtilsOpciones;

/**
 * This class builds an data access object, allowing queries on the table
 * entidade_arin in MySQL
 * 
 */
public class EntidadArinDao {

	private EntityManager em;

	public EntidadArinDao(EntityManager em) {
		this.em = em;
	}
	
	public List<EntidadArin> obteterEntidades() throws UtilsBusinessException {
		Query q = em.createQuery("SELECT e FROM EntidadArin e");
		List<EntidadArin> res = q.getResultList();
		return q.getResultList();
	}
	
	public List<EntidadArin> obteterEntidadesPorFiltro(String search) throws UtilsBusinessException {
		String query = "SELECT e FROM EntidadArin e WHERE e.idDocumento LIKE :search OR e.nome LIKE :search OR e.pais LIKE :search";
		
		if(UtilsFormato.isLongNumber(search))
			query += " OR e.id = " + search;
		
		Query q = em.createQuery(query);
		q.setParameter("search", "%"+search+"%");
		q.setMaxResults(1000);
		return q.getResultList();
	}
	
	

	private List<EntidadArin> doQueryWithArinFilters(String esMiembro, String filtros) {
		if (esMiembro.compareTo("SI") != 0) {
			String query = "SELECT e FROM EntidadArin e";
			query +=filtros;
					
			Query q = em.createQuery(query);
			return q.getResultList();
		}
		
		return new ArrayList<EntidadArin>();
	}
	
	
		public List<Object[]> obteterEntidadesConIPv6(boolean resumido) throws UtilsBusinessException {	
//		String query = "SELECT e.id, e.nome, e.tipoRenovacao, bip.version, bip.ipIncial, bip.ipFinal " +
		String query = "SELECT e.id, e.nome, bip.version, bip.ipIncial, bip.ipFinal " +
					"FROM EntidadArin e, BlocosIPArin bip " +
					"WHERE e.id = bip.entidade.id AND bip.version = 6 ";
		
		if(resumido) query += "GROUP BY e.id ";
		query += "ORDER BY e.id ";		
		
		Query q = em.createQuery(query);
		return q.getResultList();
	}
	
	
	public EntidadArin obtenerEntidadConOwnerId(String id_documento) throws UtilsBusinessException {
		Query q = em.createQuery("select e from EntidadArin e where e.idDocumento= :id_documento");
		q.setParameter("id_documento", id_documento);
		List<EntidadArin> res = q.getResultList();
		if (res.size() == 1)
			return (EntidadArin) q.getSingleResult();
		else return null;
	}

	public String obtenerEntidadConId(long id) throws UtilsBusinessException {
		Query q = em.createQuery("select e from EntidadArin e where e.id = :id");
		q.setParameter("id", id);
		return ((Entidad) q.getResultList().get(0)).getUsuarioAdm().getId();
		
	}

	public String obtenerOwnerIdconIdEntidad(long id) throws UtilsBusinessException {
		Query q = em.createQuery("select e.idDocumento from EntidadArin e where e.id = :id");
		q.setParameter("id", id);
		return (String) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<EntidadArin> obtenerEntidadesMimebroDirectoLACNICAdministradasPorUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select distinct(b.entidade) from BlocosIPArin b where (b.status = " + 1 + " or b.status= " + 0 + ") and b.usuarioAdm = :handler and b.entidade.pais!='MX'");
		q.setParameter("handler", usuario);
		List<EntidadArin> list1 = q.getResultList();

//		Query q2 = em.createQuery("select distinct(a.entidade) from AutonomousSystemArin a where a.usuarioAdm = :handler and a.entidade.pais!='MX'");
//		Query q2 = em.createQuery("select distinct(a.idEntidade) from AutonomousSystemArin a where a.usuarioAdm = :handler and a.entidade.pais!='MX'");
		Query q2 = em.createQuery("select distinct(a.idEntidade) from AutonomousSystemArin a where a.usuarioAdm = :handler");
		q2.setParameter("handler", usuario);
//		List<EntidadArin> list2 = q2.getResultList();
		List<Long> list2 = q2.getResultList();

//		for (EntidadArin enti : list2) {
//			boolean insert = true;
//			for (EntidadArin entilist1 : list1) {
//				if (entilist1.getId() == enti.getId())
//					insert = false;
//			}
//			if (insert)
//				list1.add(enti);
//		}
		
		for (Long id : list2) {
			boolean insert = true;
			for (EntidadArin entilist1 : list1) {
				if (entilist1.getId() == id)
					insert = false;
			}
			if (insert)
				list1.add(obtenerEntidadArin(id));
		}

		return list1;
	}
	
	public List<EntidadArin> obtenerTodasLasEntidadesRelacionadasConUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("SELECT e FROM EntidadArin e WHERE e.usuarioAdm = :handler");
		q.setParameter("handler", usuario);
		List<EntidadArin> list1 = q.getResultList();

		Query q2 = em.createQuery("SELECT distinct(b.entidade) FROM BlocosIPArin b WHERE (b.status = " + 1 + " or b.status= " + 0 + ") AND b.usuarioAdm = :handler OR b.usuarioSec = :handler");
		q2.setParameter("handler", usuario);
		List<EntidadArin> list2 = q2.getResultList();

//		Query q3 = em.createQuery("SELECT distinct(a.entidade) FROM AutonomousSystemArin a WHERE a.usuarioAdm = :handler OR a.usuarioSec = :handler");
		Query q3 = em.createQuery("SELECT distinct(a.idEntidade) FROM AutonomousSystemArin a WHERE a.usuarioAdm = :handler OR a.usuarioSec = :handler");
		q3.setParameter("handler", usuario);
//		List<EntidadArin> list3 = q3.getResultList();
		List<Long> list3 = q3.getResultList();

		for (EntidadArin enti : list2) {
			boolean insert = true;
			for (EntidadArin entilist1 : list1) {
				if (entilist1.getId() == enti.getId())
					insert = false;
			}
			if (insert)
				list1.add(enti);
		}

//		for (EntidadArin enti : list3) {
//			boolean insert = true;
//			for (EntidadArin entilist1 : list1) {
//				if (entilist1.getId() == enti.getId())
//					insert = false;
//			}
//			if (insert)
//				list1.add(enti);
//		}
		
		for (long id : list3) {
			boolean insert = true;
			for (EntidadArin entilist1 : list1) {
				if (entilist1.getId() == id)
					insert = false;
			}
			if (insert){
				EntidadArin entidadArin = obtenerEntidadArin(id);
				if (entidadArin != null) list1.add(entidadArin);
			}
		}

		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<EntidadArin> obtenerEntidadesMimebroDelNICMXAdministradasPorUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("SELECT distinct(b.entidade) FROM BlocosIPArin b WHERE b.usuarioAdm = :handler AND b.entidade.pais='MX' "
				+ "AND b.id IN (SELECT d.blocoDesignado FROM BlocosIPArin b2, Designacoes d WHERE b2.id=d.blocoPadre AND b2.entidade.id=20274)");
		q.setParameter("handler", usuario);
		List<EntidadArin> list1 = q.getResultList();

		Query q2 = em.createQuery("SELECT distinct(b.entidade) FROM BlocosIPArin b WHERE (b.status = " + 1 + " or b.status= " + 0 + ") AND b.usuarioAdm = :handler AND "
				+ "b.entidade.pais='MX' AND b.entidade.id!=20274");
		q2.setParameter("handler", usuario);
		List<EntidadArin> list2 = q2.getResultList();

//		Query q3 = em.createQuery("SELECT distinct(a.entidade) FROM AutonomousSystemArin a WHERE a.usuarioAdm = :handler AND a.entidade.pais='MX'");
		Query q3 = em.createQuery("SELECT distinct(a.idEntidade) FROM AutonomousSystemArin a WHERE a.usuarioAdm = :handler");
		q3.setParameter("handler", usuario);
//		List<EntidadArin> list3 = q3.getResultList();
		List<Long> list3 = q3.getResultList();

		for (EntidadArin enti : list2) {
			boolean insert = true;
			for (EntidadArin entilist1 : list1) {
				if (entilist1.getId() == enti.getId())
					insert = false;
			}
			if (insert)
				list1.add(enti);
		}

//		for (EntidadArin enti : list3) {
//			boolean insert = true;
//			for (EntidadArin entilist1 : list1) {
//				if (entilist1.getId() == enti.getId())
//					insert = false;
//			}
//			if (insert)
//				list1.add(enti);
//		}
		
		for (Long id : list3) {
			boolean insert = true;
			for (EntidadArin entilist1 : list1) {
				if (entilist1.getId() == id)
					insert = false;
			}
			if (insert)
				list1.add(obtenerEntidadArin(id));
		}

		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<EntidadArin> obtenerEntidadesAdministradasPorusuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select e from EntidadArin e where e.usuarioAdm = :handler");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}
	
	public List<EntidadArin> obtenerEntidadesUsuarioContacto(String handle) {
		Query q = em.createQuery("SELECT e FROM EntidadArin e WHERE e.usuarioAdm = :handler");
		q.setParameter("handler", handle);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<EntidadArin> obtenerEntidadesNoMexicanasAdministradasPorusuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select e from EntidadArin e where e.usuarioAdm = :handler and e.pais!='MX'");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EntidadArin> obtenerEntidadesNoMexicanasNoBrasilerasAdministradasPorusuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select e from EntidadArin e where e.usuarioAdm = :handler and e.pais!='MX' and e.pais!='BR'");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public EntidadArin obtenerEntidadArin(long idEntidad) throws UtilsBusinessException {
		return em.find(EntidadArin.class, idEntidad);
	}
	
// entidade_arin no tiene tipo_renovacao
//	public List<EntidadArin> obtenerEntidadesSinContratoRegistrado(List<Long> entidadesContrato) {
//		String query = "SELECT e FROM EntidadArin e WHERE e.tipoRenovacao > 1 AND e.id NOT IN (20000,";
//		
//		for (Long idEntidad : entidadesContrato) {
//			query += idEntidad.toString().concat(",");
//		}
//		query = query.substring(0, query.length()-1);
//		query = query + ")";
//		
//		Query q = em.createQuery(query);
//		return q.getResultList();
//	}
	
}