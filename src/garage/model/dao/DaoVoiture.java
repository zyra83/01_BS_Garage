package garage.model.dao;

import java.util.List;

import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;
import garage.model.entities.Voiture;

public interface DaoVoiture extends Dao<Voiture, String> {

	public List<Voiture> readByModele(String modele) throws DaoException;

	public List<Voiture> readAllSortByPuissance() throws DaoException;

	public long compterVoituresParMarque(Marque m);

}
