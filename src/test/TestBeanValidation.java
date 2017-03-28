package test;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import garage.model.entities.Voiture;

public class TestBeanValidation {

	@Test
	public void testBeanValidation() {
		Voiture v = new Voiture();

		v.setImmatriculation("10");
		v.setPuissance(-10);
		v.setModele("Foireux");
		v.setMiseEnCirculation(LocalDate.now());

		System.out.println(v);

		// Pour valider v j'ai besoin d'une instance de validator.
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Voiture>> set = validator.validate(v);

		// Assert.assertTrue(set.size() == 2);
		System.out.println(set.size());

		for (ConstraintViolation<Voiture> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getInvalidValue().toString());
		}

		/*
		 * try { DaoFactory.fabriquerDaoVoiture().create(v); } catch
		 * (DaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

}
