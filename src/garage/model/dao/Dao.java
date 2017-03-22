package garage.model.dao;

import java.util.List;

import garage.model.dao.exceptions.DaoException;

/**
 * Interface CRUD ++ générique
 * @author c.louer
 *
 * @param <T>
 * Type de classe à persister
 * @param <K>
 * Clé définie pour la classe (equals & hashCode)
 */
public interface Dao<T,K> {
	/**
	 * Méthode proposant la création de l'objet passé en paramètre dans le contexte de persistance.
	 * @param t
	 * Objet à persister.
	 * @throws DaoException 
	 */
	public default void create(T t) throws DaoException{
		throw new UnsupportedOperationException();
	}
			
	/**
	 * Méthode proposant la lecture d'un objet persisté à partir de la clé primaire.
	 * @param k
	 * clé primaire
	 * @return
	 * Objet lu
	 * @throws DaoException 
	 */
	public default T read(K k) throws DaoException{
		throw new UnsupportedOperationException();
	}
	/**
	 * Méthode proposant la suppression de l'objet passé en paramètre dans le contexte de persistance.
	 * @param t
	 * Objet à supprimer
	 * Objet présent dans le contexte de persistance à supprimer.
	 * @throws DaoException 
	 */
	public default void delete(T t) throws DaoException{
		throw new UnsupportedOperationException();
	}
	/**
	 * Méthode proposant la modification d'un objet existant dans le contexte de persistance.
	 * @param t
	 * Objet à modifier
	 * Objet présent dans le contexte de persistance à modifier.
	 * @throws DaoException 
	 */
	public default void update(T t) throws DaoException{
		throw new UnsupportedOperationException();
	}
	/**
	 * Méthode proposant la lecture de l'ensemble des objets présents dans le contexte de persistance.
	 * @return
	 * Retourne une liste contenant l'ensemble des objets présents dans le contexte de persistance.
	 * @throws DaoException 
	 */
	public default List<T> readAll() throws DaoException{
		throw new UnsupportedOperationException();
	}
	/**
	 * Méthode testant l'existance de l'objet passé en paramètre dans le contexte de persistance.
	 * @param t
	 * Objet recherché.
	 * @return
	 * Retourne 'true' si l'objet existe dans le contexte de persistance, 'false' sinon.
	 * @throws DaoException 
	 */
	public default boolean exist(T t) throws DaoException{
		throw new UnsupportedOperationException();
	}
		
}
