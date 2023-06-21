package org.practice.parkinglot.services;

import org.practice.parkinglot.models.Vehicle;

public interface IParkingService {
    org.practice.parkinglot.models.Ticket parkVehicle(String id, Vehicle vehicle);


    boolean unParkVehicle(org.practice.parkinglot.models.Ticket ticket);
    //
}
