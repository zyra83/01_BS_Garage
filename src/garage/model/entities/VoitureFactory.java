package garage.model.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public final class VoitureFactory {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;

	private VoitureFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Voiture fabriquerVoiture(String modele, String immatriculation, int puissance, LocalDate mec,
			Marque marque) throws Exception {

		Voiture v = new Voiture(mec, modele, puissance, immatriculation, marque);

		Set<ConstraintViolation<Voiture>> set = validator.validate(v);
		if (!set.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<Voiture> constraintViolation : set) {
				sb.append(constraintViolation.getMessage());
				sb.append(constraintViolation.getInvalidValue().toString());
				sb.append("\n");
			}
			throw new Exception(sb.toString());
		}
		return v;
	}

}
