package garage.model.entities.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPastDateValidator implements ConstraintValidator<PastDate, LocalDate> {

	@Override
	public void initialize(PastDate arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(LocalDate arg0, ConstraintValidatorContext arg1) {
		if (arg0 == null) {
			return true;
		}

		if (arg0.isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}

}
