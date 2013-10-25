package net.lacnic.ejb.service.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.lacnic.dao.mysql.MySqlDaoFactory;
import net.lacnic.dao.mysql.UsuarioDao;
import net.lacnic.ejb.service.UsuarioServiceEJB;
import net.lacnic.exception.UtilsBusinessException;

import org.apache.log4j.Logger;

@Stateless
@Remote(UsuarioServiceEJB.class)
public class UsuarioServiceEJBBean implements UsuarioServiceEJB {

	@PersistenceContext(unitName = "utils-mysql-ds")
	private EntityManager MySQLEntityManager;

	// @Resource
	// private SessionContext sessionContext;

	// @EJB
	// @Resource(mappedName = "UsuarioServiceEJBBean/remote")
	// private UsuarioServiceEJB usuarioServiceEJB;

	private UsuarioServiceEJB initUsuarioServiceEJB() throws UtilsBusinessException {
		Context ctx;
		try {
			ctx = new InitialContext();
			return (UsuarioServiceEJB) ctx.lookup("UsuarioServiceEJBBean/remote");
		} catch (NamingException e) {
			throw new UtilsBusinessException();
		}
	}



	static Logger logger = Logger.getLogger(UsuarioServiceEJBBean.class);



	

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public String obtenerClave(String usuario) throws UtilsBusinessException {
		try {
			UsuarioDao ud = MySqlDaoFactory.createUsuarioDao(MySQLEntityManager);
			return ud.obtenerClave(usuario);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new UtilsBusinessException(e);
		}

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public String obtenerLOCALE(String usuario) throws UtilsBusinessException {
		try {
			UsuarioDao ud = MySqlDaoFactory.createUsuarioDao(MySQLEntityManager);
			return ud.obtenerLOCALE(usuario);
		} catch (Exception e) {
			return "SP";
		}

	}




		
}