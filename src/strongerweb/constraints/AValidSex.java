package strongerweb.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {strongerweb.constraints.AValidSexImpl.class})
public @interface AValidSex {

	String message() default "{strongerweb.constraints.avalidsex}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
