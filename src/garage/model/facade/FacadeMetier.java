package garage.model.facade;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import garage.model.dao.DaoFactory;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class FacadeMetier implements IFacadeMetier {

	public FacadeMetier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerVoiture(Voiture v) throws DaoException {
		

		// Pour valider v j'ai besoin d'une instance de validator.
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Voiture>> set = validator.validate(v);

		log.info(set.size());

		for (ConstraintViolation<Voiture> constraintViolation : set) {
			log.warn(constraintViolation.getMessage());
			log.warn(constraintViolation.getInvalidValue().toString());
		}
		
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
