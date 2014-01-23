package org.zirbes.groovy.validation

import java.util.Set

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

import spock.lang.Specification
import spock.lang.Unroll

class BicycleSpec extends Specification {

    private static Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    void 'we can build a bicycle'() {
        given:
        Bicycle bike = new Bicycle(
            manufacturer: 'Surly',
            model: 'Steamroller',
            wheelSize: 700,
            wheelMeasurement: MeasurementType.MM,
            tireType: TireType.ROAD,
            frameSize: 40,
            frameMeasurement: MeasurementType.CM
        )

        when:
        String description = bike.toString()

        then:
        description == '40cm Surly Steamroller'
    }

    void 'a bicycle must have a make, model and frame size'() {
        given:
        Bicycle bike = new Bicycle()

        when:
        Set<ConstraintViolation<Bicycle>> violations = validator.validate(bike)

        then:
        violations.size() == 4
    }

    @Unroll
    void 'a bicycle that meets the minumum requirements for frame size #frame'() {
        given:
        Bicycle bike = new Bicycle(
            manufacturer: 'Surly',
            model: 'Steamroller',
            frameSize: frame,
            frameMeasurement: MeasurementType.CM
        )

        when:
        Set<ConstraintViolation<Bicycle>> violations = validator.validate(bike)

        then:
        violations.size() == errors
        !message || message == violations.iterator().next().message

        where:
        frame || errors | message
        10    || 1      | 'must be greater than or equal to 13'
        40    || 0      | ''
        80    || 1      | 'must be less than or equal to 62'
    }
}

