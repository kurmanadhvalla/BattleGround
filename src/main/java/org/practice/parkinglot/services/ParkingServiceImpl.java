package org.practice.parkinglot.services;

import org.practice.parkinglot.dao.IParkingTicketManagementDao;
import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.enums.TicketStatus;
import org.practice.parkinglot.models.*;
import org.practice.parkinglot.strategies.IParkingStrategy;

public class ParkingServiceImpl implements IParkingService {

    private final IParkingLotManagementService parkingLotManagementService;
    private final IParkingTicketManagementDao parkingTicketManagementDao;
    private final IParkingStrategy parkingStrategy;

    public ParkingServiceImpl(IParkingLotManagementService parkingLotManagementService, IParkingTicketManagementDao parkingTicketManagementDao,IParkingStrategy parkingStrategy) {
        this.parkingLotManagementService = parkingLotManagementService;
        this.parkingTicketManagementDao = parkingTicketManagementDao;
        this.parkingStrategy =parkingStrategy;
    }

    @Override
    public Ticket parkVehicle(String parkingLotId, Vehicle vehicle) {
        ParkingLot parkingLot = parkingLotManagementService.getParkingLotById(parkingLotId);
        ParkingSlot parkingSlot = parkingStrategy.allocateSlot(parkingLot,vehicle);
        parkingSlot.setOccupied(true);
        Ticket ticket = parkingTicketManagementDao.createTicket(parkingLotId,parkingSlot.getFloorId(),parkingSlot,vehicle);
        System.out.println("PARKED " +ticket.toString());
        return ticket;
        //throw new SLotsNotAvailableException()
    }



    @Override
    public boolean unParkVehicle(Ticket ticket) {
        ticket.getSlot().setOccupied(false);
        parkingTicketManagementDao.closeTicket(ticket);
        System.out.println("UNPARKED " +ticket.toString());

        return false;
    }


}
