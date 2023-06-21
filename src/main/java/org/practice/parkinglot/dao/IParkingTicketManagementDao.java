package org.practice.parkinglot.dao;

import org.practice.parkinglot.models.ParkingSlot;
import org.practice.parkinglot.models.Ticket;
import org.practice.parkinglot.models.Vehicle;

public interface IParkingTicketManagementDao {
    Ticket createTicket(String parkingLotId, int floorId, ParkingSlot slot, Vehicle vehicle);

    Ticket closeTicket(Ticket ticket);
}
