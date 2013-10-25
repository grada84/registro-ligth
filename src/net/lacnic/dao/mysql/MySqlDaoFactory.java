package net.lacnic.dao.mysql;

import javax.persistence.EntityManager;
/**This class is Factory Data Access Object
 *
 */
public class MySqlDaoFactory {
	private MySqlDaoFactory() {
	}
	
	public static UsuarioDao createUsuarioDao(EntityManager em) {
		return new UsuarioDao(em);
	}
	
	public static EntidadDao createEntidadDao(EntityManager em) {
		return new EntidadDao(em);
	}
	


	public static UsuarioArinDao createUsuarioArinDao(EntityManager em) {
		return new UsuarioArinDao(em);
	}

	

	public static EntidadArinDao createEntidadArinDao(EntityManager em) {
		return new EntidadArinDao(em);
	}

	
}
