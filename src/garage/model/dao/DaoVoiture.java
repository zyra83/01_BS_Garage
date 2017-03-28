package garage.model.dao;

import java.util.List;

import garage.model.dao.exceptions.DaoException;

public interface DaoVoiture<T, K> extends Dao<T, K> {

	public List<T> readByModele(K modele) throws DaoException;

	public List<T> readAllSortByPuissance() throws DaoException;

}
