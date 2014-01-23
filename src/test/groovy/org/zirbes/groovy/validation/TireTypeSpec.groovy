package org.zirbes.groovy.validation

import spock.lang.Specification

class TireTypeSpec extends Specification {

    void 'ensure there are adequite tire types'() {
        expect:
        TireType.ROAD.toString() == 'Road'
        TireType.MOUNTAIN.toString() == 'Mountain'
        TireType.STUDDED.toString() == 'Studded'
    }
}
