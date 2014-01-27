package org.zirbes.groovy.validation

import static java.lang.annotation.ElementType.TYPE
import static java.lang.annotation.RetentionPolicy.RUNTIME

import java.lang.annotation.Retention
import java.lang.annotation.Target

import javax.validation.Constraint
import javax.validation.Payload

@Constraint(validatedBy = BicycleValidator.class)
@Target([TYPE])
@Retention(RUNTIME)
public @interface ValidBicycle {

    String message() default 'That is not a real bike.'

    Class<?>[] groups() default []

    Class<? extends Payload>[] payload() default []

}
