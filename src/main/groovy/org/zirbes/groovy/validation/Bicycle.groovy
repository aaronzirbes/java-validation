package org.zirbes.groovy.validation

class Bicycle {

    String manufacturer

    String model

    Integer wheelSize

    MeasurementType wheelMeasurement

    TireType tireType

    Integer frameSize

    MeasurementType frameMeasurement

    String toString() {
        "${frameSize}${frameMeasurement.name().toLowerCase()} ${manufacturer} ${model}"
    }
}
