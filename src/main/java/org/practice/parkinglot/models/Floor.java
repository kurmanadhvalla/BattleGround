package org.practice.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import org.practice.parkinglot.enums.ParkingSlotType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class Floor {
    private final int floorId;
    private final Map<ParkingSlotType, List<ParkingSlot>> parkingSlots;
    private  int capacity;


    public Floor(int floorId, int capacity) {
        this.floorId = floorId;
        this.capacity = capacity;
        this.parkingSlots = new HashMap<>();
    }
}
