package org.practice.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import org.practice.parkinglot.enums.ParkingSlotType;


@Getter
@Setter
public class ParkingSlot {
    private final int parkingSlotId;
    private final ParkingSlotType type;
    private final int floorId;
    private final String parkingLotId;

    private boolean isOccupied;

    public ParkingSlot(int parkingSlotId, ParkingSlotType type, int floorId, String parkingLotId) {
        this.parkingSlotId = parkingSlotId;
        this.type = type;
        this.floorId = floorId;
        this.parkingLotId = parkingLotId;
        this.isOccupied =false;
    }


}
