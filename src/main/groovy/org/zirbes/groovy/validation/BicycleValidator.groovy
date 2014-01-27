package org.zirbes.groovy.validation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class BicycleValidator implements ConstraintValidator<ValidBicycle, Bicycle> {

    static final List<String> SURLY_BIKES = [
        'Moon Lander',
        'Pug Ops',
        'Pugsley',
        'Cross-Check',
        'Straggler',
        'Pacer',
        'Steamroller',
        'Long Haul Trucker',
        'Troll',
        'Ogre',
        'Big Dummy'
    ]

    @Override
    public void initialize(ValidBicycle constraintAnnotation) {
        // initialze any custom annotation options
    }

    /**
     * Validate zipcode and city depending on the country
     */
    @Override
    public boolean isValid(Bicycle bicycle, ConstraintValidatorContext ctx) {
        boolean isValid = true

        if (bicycle.manufacturer == 'Surly') {
            if (! (bicycle.model in SURLY_BIKES) ) {
                String message = "${bicycle.manufacturer} does not make a ${bicycle.model} model."
                ctx.buildConstraintViolationWithTemplate(message)
                        .addNode('model')
                        .addConstraintViolation()

                isValid = false
            }
        }

        return isValid
    }

}
