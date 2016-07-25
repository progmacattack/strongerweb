package strongerweb.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jboss.logging.Logger;

public class AValidWeightImpl implements ConstraintValidator<AValidWeight, String> {
	Logger logger = Logger.getLogger(this.getClass());
	
	private int min;
	private int max;
	
	@Override
	public void initialize(AValidWeight constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		int validWeight = 0;
		if (value.matches("[0-9]{1,3}")) {
			try {
				validWeight = Integer.parseInt(value);
			} catch (NumberFormatException nfe) {
				logger.info(nfe.getMessage());
				logger.info("Tried to parse " + value + " to int in: " + nfe.getClass());
			}
		} else {
			return false;
		}
		
		if (validWeight >= min && validWeight <= max) {
			return true;
		} else {
			return false;
		}
	}

}
