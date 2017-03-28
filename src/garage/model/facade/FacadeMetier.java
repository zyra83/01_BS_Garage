package garage.model.facade;

import java.util.List;

import garage.model.dao.DaoFactory;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;

public class FacadeMetier implements IFacadeMetier {

	public FacadeMetier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerVoiture(Voiture v) throws DaoException {
		DaoFactory.fabriquerDaoVoiture().create(v);
	}

	@Override
	public void supprimerVoiture(Voiture v) throws DaoException {
		DaoFactory.fabriquerDaoVoiture().delete(v);
	}

	@Override
	public List<Voiture> listerLesVoitures() throws DaoException {
		return DaoFactory.fabriquerDaoVoiture().readAll();
	}

	@Override
	public List<Voiture> listerLesVoituresParPuissance() throws DaoException {
		return DaoFactory.fabriquerDaoVoiture().readAllSortByPuissance();
	}

	@Override
	public List<Voiture> rechercherVoiture(String recherche) throws DaoException {
		return DaoFactory.fabriquerDaoVoiture().readByModele(recherche);
	}

	@Override
	public void mettreAjourUneVoiture(Voiture v) throws DaoException {
		DaoFactory.fabriquerDaoVoiture().update(v);
	}

}
