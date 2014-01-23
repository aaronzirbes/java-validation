package org.zirbes.groovy.validation

enum TireType {

    ROAD('Road'),
    MOUNTAIN('Mountain'),
    STUDDED('Studded')

    TireType(String desc) {
        this.desc = desc
    }

    String desc

    String toString() { desc }

}
