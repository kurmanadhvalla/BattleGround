package org.practice.parkinglot.services;

import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;

import java.util.List;
import java.util.Map;

public interface IParkingLotManagementService {
    ParkingLot createParkingLot(String name, String address);

    boolean addFloor(String parkingLotId, int capacity, Map<ParkingSlotType, Integer> capacityAndSlotTypeMap);


    ParkingSlot addParkingSlot(String parkingLotId, int floorId, ParkingSlotType type);

    List<ParkingSlot> getParkingSlots(String parkingSlotId, int floorId);

    ParkingLot getParkingLotById(String parkingLotId);
}
