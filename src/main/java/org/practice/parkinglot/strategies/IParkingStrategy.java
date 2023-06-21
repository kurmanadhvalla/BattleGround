package org.practice.parkinglot.strategies;

import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;
import org.practice.parkinglot.models.Vehicle;

public interface IParkingStrategy {

    ParkingSlot allocateSlot(ParkingLot parkingSlot, Vehicle vehicle);
}
