package org.practice.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.practice.parkinglot.enums.VehicleType;


@AllArgsConstructor
@Getter
@Setter
public class Vehicle {

    private final  String registrationNum;
    private final VehicleType vehicleType;

}
