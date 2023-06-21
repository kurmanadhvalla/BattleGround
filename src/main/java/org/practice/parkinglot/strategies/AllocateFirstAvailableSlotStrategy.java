package org.practice.parkinglot.strategies;

import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.models.Floor;
import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;
import org.practice.parkinglot.models.Vehicle;

public class AllocateFirstAvailableSlotStrategy implements IParkingStrategy{
    @Override
    public ParkingSlot allocateSlot(ParkingLot parkingLot, Vehicle vehicle) {
        for(Floor floor :parkingLot.getFloors()){
            for(ParkingSlot slot : floor.getParkingSlots().get(ParkingSlotType.getParkingSlotType(vehicle.getVehicleType()))){
                if(!slot.isOccupied())
                {
                    return slot;
                }
            }
        }
        return null;
    }
}
