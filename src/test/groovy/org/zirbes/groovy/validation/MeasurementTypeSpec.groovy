package org.zirbes.groovy.validation

import spock.lang.Specification

class MeasurementTypeSpec extends Specification {

    void 'ensure there are adequite measurement variants'() {
        expect:
        MeasurementType.MM.toString() == 'Millimeters'
        MeasurementType.CM.toString() == 'Centimeters'
        MeasurementType.IN.toString() == 'Inches'
    }
}
