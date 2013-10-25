package net.lacnic.ejb.service;

import javax.ejb.Remote;

import net.lacnic.ejb.service.impl.UsuarioServiceEJBBean;
import net.lacnic.exception.UtilsBusinessException;

/**
 * Interface EJB, DAO service on usuarios table {@link UsuarioServiceEJBBean}
 */

@Remote
public interface UsuarioServiceEJB {


	String obtenerClave(String handle) throws UtilsBusinessException;


	String obtenerLOCALE(String usuario) throws UtilsBusinessException;



}