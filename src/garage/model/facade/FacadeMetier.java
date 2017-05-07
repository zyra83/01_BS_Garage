package garage.model.facade;

import java.util.List;

import garage.model.dao.DaoFactory;
import garage.model.dao.DaoMarque;
import garage.model.dao.DaoVoiture;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;
import garage.model.entities.Voiture;
import garage.model.facade.exceptions.FacadeMetierException;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class FacadeMetier implements IFacadeMetier {

	private DaoVoiture persistenceV = DaoFactory.fabriquerDaoVoiture();
	private DaoMarque persistenceM = DaoFactory.fabriquerDaoMarque();

	public FacadeMetier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerVoiture(Voiture v) throws FacadeMetierException {
		try {
			persistenceV.create(v);
			if (log.isInfoEnabled()) {
				log.info(String.format("Création de la voiture %s", v));
			}
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn("Création de la voiture impossible");
			}
			throw new FacadeMetierException("Création de la voiture impossible", e);
		}
	}

	@Override
	public void supprimerVoiture(Voiture v) throws FacadeMetierException {
		try {
			persistenceV.delete(v);
			if (log.isInfoEnabled()) {
				log.info(String.format("Delete de la voiture %s", v));
			}
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn("Delete de la voiture impossible");
			}
			throw new FacadeMetierException("Delete de la voiture impossible", e);
		}
	}

	@Override
	public List<Voiture> listerLesVoitures() throws FacadeMetierException {
		try {
			List<Voiture> lstv = persistenceV.readAll();
			if (log.isInfoEnabled()) {
				log.info(String.format("Lecture des voitures"));
			}
			return lstv;
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn("Lecture des voitures impossible");
			}
			throw new FacadeMetierException("Lecture des voitures impossible", e);
		}
	}

	@Override
	public List<Voiture> listerLesVoituresParPuissance() throws FacadeMetierException {
		try {
			List<Voiture> lstv = persistenceV.readAllSortByPuissance();
			if (log.isInfoEnabled()) {
				log.info(String.format("Lecture des voitures par puissance"));
			}
			return lstv;
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn("Lecture des voitures impossible par puissance");
			}
			throw new FacadeMetierException("Lecture des voitures impossible par puissance", e);
		}
	}

	@Override
	public List<Voiture> rechercherVoiture(String recherche) throws FacadeMetierException {
		try {
			List<Voiture> lstv = persistenceV.readByModele(recherche);
			if (log.isInfoEnabled()) {
				log.info(String.format("Lecture des voitures par modele"));
			}
			return lstv;
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn("Lecture des voitures impossible par modele");
			}
			throw new FacadeMetierException("Lecture des voitures impossible par modele", e);
		}
	}

	@Override
	public void mettreAjourUneVoiture(Voiture v) throws FacadeMetierException {
		try {
			persistenceV.update(v);
			if (log.isInfoEnabled()) {
				log.info(String.format("Update de la voiture %s", v));
			}
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn(String.format("Update de la voiture impossible: %s", e.getMessage()));
			}
			throw new FacadeMetierException("Update de la voiture impossible", e);
		}
	}

	public List<Marque> listerLesMarques() throws FacadeMetierException {
		try {
			List<Marque> lstv = persistenceM.readAll();
			if (log.isInfoEnabled()) {
				log.info(String.format("Lecture des marques"));
			}
			return lstv;
		} catch (DaoException e) {
			if (log.isWarnEnabled()) {
				log.warn("Lecture des marques impossible");
			}
			throw new FacadeMetierException("Lecture des marques impossible", e);
		}
	}
	
	public long compterVoituresParMarque(Marque m){
		//Soit je demande a la persistance qui m'execute une requete jpql
		return persistenceV.compterVoituresParMarque(m);
		//Soit :comme la marque "connait" ses voitures ( et donc porte une collection de voitures en son sein)
		//return m.getLesVoitures().size();
	}

}
