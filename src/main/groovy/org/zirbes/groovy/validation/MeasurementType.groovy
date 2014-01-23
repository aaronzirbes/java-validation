package org.zirbes.groovy.validation

enum MeasurementType {
    MM('Millimeters'),
    CM('Centimeters'),
    IN('Inches')

    MeasurementType(String desc) {
        this.desc = desc
    }

    String desc

    String toString() { desc }

}
