package strongerweb.constraints;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jboss.logging.Logger;
import org.springframework.validation.annotation.Validated;

public class AValidSexImpl implements ConstraintValidator<AValidSex, String> {
	Logger logger = Logger.getLogger(this.getClass());
	
	private List<String> validSexes = Arrays.asList("male","female"); //comma separated list of acceptable values
	
	@Override
	public void initialize(AValidSex constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		logger.info("Validating " + value + "...");
		if(value != null) {
			for(String sex : validSexes) {
				if (value.toLowerCase().equals(sex)) {
					return true;
				}
			}
		}
		logger.info(value + " not valid. Returning false.");
		return false;
	}
}
