package org.zirbes.groovy.validation

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

class Bicycle {

    @NotNull
    String manufacturer

    @NotNull
    String model

    @Min(16L)
    Integer wheelSize

    MeasurementType wheelMeasurement

    TireType tireType

    @Min(13L)
    @Max(62L)
    @NotNull
    Integer frameSize

    @NotNull
    MeasurementType frameMeasurement

    String toString() {
        "${frameSize}${frameMeasurement.name().toLowerCase()} ${manufacturer} ${model}"
    }
}
