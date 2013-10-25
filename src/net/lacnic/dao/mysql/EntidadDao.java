package net.lacnic.dao.mysql;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.lacnic.domain.mysql.Entidad;
import net.lacnic.domain.mysql.O3Cliente;
import net.lacnic.exception.UtilsBusinessException;
import net.lacnic.registro.commons.utils.UtilsFechas;
import net.lacnic.registro.commons.utils.UtilsFormato;
import net.lacnic.registro.commons.utils.UtilsOpciones;

/**
 * This class builds an data access object, allowing queries on the table
 * entidade in MySQL
 * 
 */
public class EntidadDao {

	private EntityManager em;

	public EntidadDao(EntityManager em) {
		this.em = em;
	}
	
	@Deprecated
	public List<Entidad> obteterEntidades() throws UtilsBusinessException {
		// Query q = em.createQuery("SELECT e FROM Entidad e");
		Query q = em.createQuery("SELECT e FROM Entidad e WHERE e.id > 20000");
		return q.getResultList();
	}

	public boolean esContactoDeUnaEntidad(String username) {
		Query q = em.createQuery("select count(e.id) from Entidad e where (e.usuarioAdm.id = :username OR e.usuarioCob.id= :username OR e.usuarioMem.id= :username ) AND e.o3Cliente.miembro=1");
		q.setParameter("username", username);
		return Integer.valueOf(q.getResultList().get(0).toString()) > 1;
	}
	public List<Entidad> obteterEntidadesPorFiltro(String search) throws UtilsBusinessException {
		String query = "SELECT e FROM Entidad e WHERE e.idDocumento LIKE :search OR e.nome LIKE :search OR e.endPais LIKE :search OR e.endCidade LIKE :search";
		
		if (UtilsFormato.isLongNumber(search))
			query += " OR e.id = " + search;

		Query q = em.createQuery(query);
		q.setParameter("search", "%" + search + "%");
		q.setMaxResults(6000);//agregado por gerardo el 17 de octubre para ver si evita que se muera el server por esta consulta
		return q.getResultList();
	}

	
	public List<Object[]> obteterEntidadesConIPv6(boolean resumido) throws UtilsBusinessException {
		// String query =
		// "SELECT e.id, e.nome, e.tipoRenovacao, bip.version, bip.ipIncial, bip.ipFinal "
		// +
		String query = "SELECT e.id, e.nome, e.o3Cliente.tipoCliente, bip.version, bip.ipIncial, bip.ipFinal " + "FROM Entidad e, BlocosIP bip " + "WHERE e.id = bip.entidade.id AND bip.version = 6 ";

		if (resumido)
			query += "GROUP BY e.id ";
		query += "ORDER BY e.id ";

		Query q = em.createQuery(query);
		return q.getResultList();
	}

	public Entidad obtenerEntidadConOwnerId(String idDocumento) throws UtilsBusinessException {
		Query q = em.createQuery("select e from Entidad e where e.idDocumento= :id_documento");
		q.setParameter("id_documento", idDocumento);
		List<Entidad> res = q.getResultList();
		if (res.size() == 1)
			return (Entidad) q.getSingleResult();
		else
			return null;
	}

	public String obtenerCategoria(String idDocumento) throws UtilsBusinessException {
		Query q = em.createQuery("select o3.tipoCliente from O3Cliente o3 where o3.idDocumento= :idDocumento");
		q.setParameter("idDocumento", idDocumento);
		List<String> res = q.getResultList();
		if (res.size() == 1)
			return (String) q.getSingleResult();
		else
			return "";
	}

	public Timestamp obtenerFechaAniversarioEntidad(String idDocumento) throws UtilsBusinessException {
		Query q = em.createQuery("select e.dataRenovacao from Entidad e where e.idDocumento= :id_documento");
		q.setParameter("id_documento", idDocumento);
		return (Timestamp) q.getSingleResult();
	}

	public String obtenerEntidadConId(long id) throws UtilsBusinessException {
		Query q = em.createQuery("select e from Entidad e where e.id = :id");
		q.setParameter("id", id);
		List res = q.getResultList();
		return ((Entidad) res.get(0)).getUsuarioAdm().getId();

	}

	public String obtenerOwnerIdconIdEntidad(long id) throws UtilsBusinessException {
		Query q = em.createQuery("select e.idDocumento from Entidad e where e.id = :id");
		q.setParameter("id", id);
		return (String) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesMimebroDirectoLACNICAdministradasPorUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select distinct(b.entidade) from BlocosIP b where (b.status = " + 1 + " or b.status= " + 0 + ") and b.usuarioAdm.id = :handler and b.entidade.endPais!='MX'");
		q.setParameter("handler", usuario);
		List<Entidad> list1 = q.getResultList();

		Query q2 = em.createQuery("select distinct(a.entidade) from AutonomousSystem a where a.usuarioAdm.id = :handler and a.entidade.endPais!='MX'");
		q2.setParameter("handler", usuario);
		List<Entidad> list2 = q2.getResultList();

		for (Entidad enti : list2) {
			boolean insert = true;
			for (Entidad entilist1 : list1) {
				if (entilist1.getId() == enti.getId())
					insert = false;
			}
			if (insert)
				list1.add(enti);
		}
		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesMimebroDirectoLACNICUsuarioComoAdministradorEntidad(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select distinct(b.entidade) from BlocosIP b where (b.status = " + 1 + " or b.status= " + 0 + ") and b.entidade.usuarioAdm.id = :handler and b.entidade.endPais!='MX'");
		q.setParameter("handler", usuario);
		List<Entidad> list1 = q.getResultList();
		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesMimebroDirectoLACNICUsuarioComoAdministradorBloques(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select distinct(b.entidade) from BlocosIP b where (b.status = " + 1 + " or b.status= " + 0 + ") and b.usuarioAdm.id = :handler AND b.entidade.endPais!='MX'");
		q.setParameter("handler", usuario);
		List<Entidad> list1 = q.getResultList();
		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<String> obtenerOrgIdMimebroDirectoLACNICUsuarioComoAdministradorBloques(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select distinct(b.entidade.idDocumento) from BlocosIP b where (b.status = " + 1 + " or b.status= " + 0 + ") and b.usuarioAdm.id = :handler and b.entidade.endPais!='MX'");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}

	// public List<Entidad>
	// obtenerTodasLasEntidadesRelacionadasConUsuario(String usuario) throws
	// UtilsBusinessException {
	// Query q =
	// em.createQuery("SELECT e FROM Entidad e WHERE e.usuarioAdm.id = :handler OR e.usuarioCob.id = :handler OR e.usuarioMem.id = :handler");
	// q.setParameter("handler", usuario);
	// List<Entidad> list1 = q.getResultList();
	//
	// Query q2 =
	// em.createQuery("SELECT distinct(b.entidade) FROM BlocosIP b WHERE (b.status = "
	// + 1 + " or b.status= " + 0 +
	// ") AND b.usuarioAdm.id = :handler OR b.usuarioSec.id = :handler");
	// q2.setParameter("handler", usuario);
	// List<Entidad> list2 = q2.getResultList();
	//
	// // Query q3 =
	// em.createQuery("SELECT distinct(a.entidade) FROM AutonomousSystem a WHERE a.usuarioAdm.id = :handler OR a.usuarioSec.id = :handler");
	// // q3.setParameter("handler", usuario);
	// // List<Entidad> list3 = q3.getResultList();
	//
	// for (Entidad enti : list2) {
	// boolean insert = true;
	// for (Entidad entilist1 : list1) {
	// if (entilist1.getId() == enti.getId())
	// insert = false;
	// }
	// if (insert)
	// list1.add(enti);
	// }
	//
	// // for (Entidad enti : list3) {
	// // boolean insert = true;
	// // for (Entidad entilist1 : list1) {
	// // if (entilist1.getId() == enti.getId())
	// // insert = false;
	// // }
	// // if (insert)
	// // list1.add(enti);
	// // }
	//
	// return list1;
	// }

	public List<Entidad> obtenerTodasLasEntidadesMiembroRelacionadasConUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("SELECT e FROM Entidad e WHERE (e.usuarioAdm.id = :handler OR e.usuarioCob.id = :handler OR e.usuarioMem.id = :handler)  AND e.tipoRenovacao > 1");
		q.setParameter("handler", usuario);
		List<Entidad> list1 = q.getResultList();

		// Query q2 =
		// em.createQuery("SELECT distinct(b.entidade) FROM BlocosIP b WHERE (b.status = "
		// + 1 + " or b.status= " + 0 +
		// ") AND (b.usuarioAdm.id = :handler OR b.usuarioSec.id = :handler)");
		// q2.setParameter("handler", usuario);
		// List<Entidad> list2 = q2.getResultList();

		// Query q3 =
		// em.createQuery("SELECT distinct(a.entidade) FROM AutonomousSystem a WHERE a.usuarioAdm.id = :handler OR a.usuarioSec.id = :handler");
		// q3.setParameter("handler", usuario);
		// List<Entidad> list3 = q3.getResultList();

		// for (Entidad enti : list2) {
		// boolean insert = true;
		// for (Entidad entilist1 : list1) {
		// if (entilist1.getId() == enti.getId())
		// insert = false;
		// }
		// if (insert)
		// list1.add(enti);
		// }

		// for (Entidad enti : list3) {
		// boolean insert = true;
		// for (Entidad entilist1 : list1) {
		// if (entilist1.getId() == enti.getId())
		// insert = false;
		// }
		// if (insert)
		// list1.add(enti);
		// }

		return list1;
	}

	public List<O3Cliente> obtenerTodasLasEntidadesO3MiembroRelacionadasConUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("SELECT e.o3Cliente FROM Entidad e WHERE (e.usuarioAdm.id = :handler OR e.usuarioCob.id = :handler OR e.usuarioMem.id = :handler)  AND e.o3Cliente.miembro = 1");
		q.setParameter("handler", usuario);
		List<O3Cliente> list1 = q.getResultList();
		return list1;
	}

	public List<Entidad> obtenerTodasLasEntidadesRelacionadasConUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("SELECT DISTINCT(e) FROM Entidad e WHERE (e.usuarioAdm.id = :handler OR e.usuarioCob.id = :handler OR e.usuarioMem.id = :handler)");
		q.setParameter("handler", usuario);
		List<Entidad> list1 = q.getResultList();
		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesMimebroDelNICMXAdministradasPorUsuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("SELECT distinct(b.entidade) FROM BlocosIP b WHERE b.usuarioAdm.id = :handler AND b.entidade.endPais='MX' " + "AND b.id IN (SELECT d.blocoDesignado FROM BlocosIP b2, Designacoes d WHERE b2.id=d.blocoPadre AND b2.entidade.id=20274)");
		q.setParameter("handler", usuario);
		List<Entidad> list1 = q.getResultList();

		Query q2 = em.createQuery("SELECT distinct(b.entidade) FROM BlocosIP b WHERE (b.status = " + 1 + " or b.status= " + 0 + ") AND b.usuarioAdm.id = :handler AND " + "b.entidade.endPais='MX' AND b.entidade.id!=20274");
		q2.setParameter("handler", usuario);
		List<Entidad> list2 = q2.getResultList();

		Query q3 = em.createQuery("SELECT distinct(a.entidade) FROM AutonomousSystem a WHERE a.usuarioAdm.id = :handler AND a.entidade.endPais='MX'");
		q3.setParameter("handler", usuario);
		List<Entidad> list3 = q3.getResultList();

		for (Entidad enti : list2) {
			boolean insert = true;
			for (Entidad entilist1 : list1) {
				if (entilist1.getId() == enti.getId())
					insert = false;
			}
			if (insert)
				list1.add(enti);
		}

		for (Entidad enti : list3) {
			boolean insert = true;
			for (Entidad entilist1 : list1) {
				if (entilist1.getId() == enti.getId())
					insert = false;
			}
			if (insert)
				list1.add(enti);
		}

		return list1;
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesAdministradasPorusuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select e from Entidad e where e.usuarioAdm.id = :handler");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}

	public List<Entidad> obtenerEntidadesUsuarioContacto(String handle) {
		Query q = em.createQuery("SELECT e FROM Entidad e WHERE e.usuarioAdm.id = :handler OR e.usuarioCob.id = :handler OR e.usuarioMem.id = :handler");
		q.setParameter("handler", handle);
		return q.getResultList();
	}
	
	public List<Entidad> obtenerEntidadesLivianoUsuarioContacto(String handle)
	{
		Query q = em.createQuery("SELECT e.nome, e.idDocumento, e.nomeContato, e.telDDD, e.telDDI, e.telNumero, e.telRamal, e.endLogradouro, e.endNumero, e.endComplemento, e.endCidade, e.endPais, e.dataRenovacao, e.dataUltalt, e.dataCadastro FROM Entidad e WHERE e.usuarioAdm.id = :handler OR e.usuarioCob.id = :handler OR e.usuarioMem.id = :handler");
		q.setParameter("handler", handle);
		List<Object[]> listaObjects =  q.getResultList();
		List<Entidad> entidadesLivianas = new ArrayList<Entidad>();
		for(int i=0;i<listaObjects.size(); i++)
		{
			Object[] actual = listaObjects.get(i);
			Entidad e = new Entidad();
			e.setNome((String) actual[0]);
			e.setIdDocumento((String) actual[1]);
			e.setNomeContato((String) actual[2]);
			e.setTelDDD((String) actual[3]);
			e.setTelDDI((String) actual[4]);
			e.setTelNumero((String) actual[5]);
			e.setTelRamal((String) actual[6]);
			e.setEndLogradouro((String) actual[7]);
			e.setEndNumero((String) actual[8]);
			e.setEndComplemento((String) actual[9]);
			e.setEndCidade((String) actual[10]);
			e.setEndPais((String) actual[11]);
			e.setDataRenovacao((Date) actual[12]);
			e.setDataUltalt((Date) actual[13]);
			e.setDataCadastro((Date) actual[14]);
			entidadesLivianas.add(e);
		}
		return entidadesLivianas;
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesNoMexicanasAdministradasPorusuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select e from Entidad e where e.usuarioAdm.id = :handler and e.endPais!='MX'");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesNoMexicanasNoBrasilerasAdministradasPorusuario(String usuario) throws UtilsBusinessException {
		Query q = em.createQuery("select e from Entidad e where e.usuarioAdm.id = :handler and e.endPais!='MX' and e.endPais!='BR'");
		q.setParameter("handler", usuario);
		return q.getResultList();
	}

	public List<Entidad> obtenerEntidadesSinContratoRegistrado(List<String> entidadesContrato) {
		String query = "SELECT e FROM Entidad e WHERE e.tipoRenovacao > 1 AND e.idDocumento NOT IN ('20000',";

		for (String orgId : entidadesContrato) {
			query += "'" + orgId.concat("',");
		}
		query = query.substring(0, query.length() - 1);
		query = query + ")";

		Query q = em.createQuery(query);
		return q.getResultList();
	}

	// public List<Entidad> obtenerEntidadesMiembro() {
	// Query q =
	// em.createQuery("select DISTINCT(e) from Entidad e where e.tipoRenovacao>1");
	// return q.getResultList();
	// }
	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerEntidadesMiembro() {
		Query q = em.createQuery("SELECT org.entidad FROM O3Cliente org WHERE org.entidad.tipoRenovacao>1");
		return q.getResultList();
	}

	public boolean tieneIPV6(String idDocumento) {
		Query q = em.createQuery("SELECT b.id FROM BlocosIP b WHERE b.version = 6 AND b.entidade.idDocumento=:idDocumento");
		q.setParameter("idDocumento", idDocumento);
		q.setMaxResults(1);
		return !q.getResultList().isEmpty();
	}
	
	public  List<Object[]> obtenerBloquesIpv6(String idDocumento) {
		Query q = em.createQuery("SELECT b.ipIncial, b.ipFinal, b.status FROM BlocosIP b WHERE b.version = 6 AND b.entidade.idDocumento=:idDocumento");
		q.setParameter("idDocumento", idDocumento);
		return q.getResultList();

	}

	public List<String[]> obtenerListaOwnerIds() {
		Query q = em.createQuery("SELECT entidade.idDocumento, entidade.nome FROM Entidad entidade");
		Query q2 = em.createQuery("SELECT entidade.idDocumento, entidade.nome FROM EntidadArin entidade");
		List resultList = q.getResultList();
		List resultList2 = q2.getResultList();
		resultList.addAll(resultList2);
		return resultList;
	}

}