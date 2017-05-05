package garage.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe utilitaire Singleton capable de fournir l'instance d'Entity Manager
 *  d'une unité de persistence( cf. persistence.xml) passée en paramètre de la méthode
 * @author nicolas.magniez
 *
 */
public final class JPAUtils {
	
	private JPAUtils() {
		// TODO Auto-generated constructor stub
	}

	private static EntityManager em;

	public synchronized static EntityManager getEm(String unitName)  {
		if ( em==null){
			em = Persistence.createEntityManagerFactory(unitName).createEntityManager();
		}
		return em;
	}
}
