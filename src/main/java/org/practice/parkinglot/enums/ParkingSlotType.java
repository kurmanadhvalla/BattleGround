package org.practice.parkinglot.enums;

public enum ParkingSlotType {
    CAR,
    TRUCK,
    BUS;

     ParkingSlotType(){

    }
    public static  ParkingSlotType getParkingSlotType(VehicleType type){
        switch (type){
            case CAR:
                return ParkingSlotType.CAR;
            case BUS:
                return  ParkingSlotType.BUS;
            default:
                return null;

        }
    }
}
