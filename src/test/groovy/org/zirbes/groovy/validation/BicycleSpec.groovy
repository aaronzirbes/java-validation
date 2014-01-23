package org.zirbes.groovy.validation

import spock.lang.Specification

class BicycleSpec extends Specification {

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
}

