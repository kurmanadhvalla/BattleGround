package org.practice.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import org.practice.parkinglot.enums.TicketStatus;

import java.time.LocalDateTime;


@Getter
@Setter
public class Ticket {

    private final String ticketId;
    private final String parkingLotId;
    private final int floorId;
    private final ParkingSlot slot;

    private final Vehicle vehicle;

    private TicketStatus ticketStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Ticket(String ticketId, String parkingLotId, int floorId, ParkingSlot slot, Vehicle vehicle) {
        this.ticketId=ticketId;
        this.parkingLotId = parkingLotId;
        this.floorId = floorId;
        this.slot = slot;
        this.vehicle = vehicle;
        this.ticketStatus =TicketStatus.OPEN;
        this.createdAt =LocalDateTime.now();
        this.updatedAt =LocalDateTime.now();

    }

    @Override
    public String toString(){
        return vehicle.getVehicleType() +" - " +vehicle.getRegistrationNum() + "  on  " + parkingLotId +"  "+floorId +"  " +slot.getParkingSlotId()  ;
    }
}
