package strongerweb.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidUsernameImpl implements ConstraintValidator<ValidUsername, String>{
	private int min;
	private int max;
	
	@Override
	public void initialize(ValidUsername constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (username.length() < min) {
			return false;
		}
		
		if (username.length() > max) {
			return false;
		}
		
		return true;
	}

}
