package org.practice.parkinglot.dao;

import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.enums.TicketStatus;
import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;
import org.practice.parkinglot.models.Ticket;
import org.practice.parkinglot.models.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IParkingLotManagementDao {
    ParkingLot createParkingLot(String name, String address);

    boolean addFloor(String parkingLotId, int capacity, Map<ParkingSlotType, Integer> capacityAndSlotTypeMap);

    ParkingLot getParkingLotById(String parkingLotId);

    ParkingSlot addParkingSlot(String parkingLotId, int floorId, ParkingSlotType type);

    List<ParkingSlot> getParkingSlots(String parkingLotId, int floorId);

    class ParkingTicketManagementDaoImpl implements IParkingTicketManagementDao {

        private final Map<String,Map<String, Ticket>> parkingTicketsMap;

        public ParkingTicketManagementDaoImpl(){
            this.parkingTicketsMap = new HashMap<>();
        }

        @Override
        public Ticket createTicket(String parkingLotId, int floorId, ParkingSlot slot, Vehicle vehicle) {
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), parkingLotId,floorId,slot,vehicle);
            Map<String,Ticket> tickets = parkingTicketsMap.getOrDefault(parkingLotId,new HashMap<>());
            tickets.put(ticket.getTicketId(),ticket);
            parkingTicketsMap.put(parkingLotId,tickets);
            return ticket;
        }

        @Override
        public Ticket closeTicket(Ticket ticket) {
            parkingTicketsMap.get(ticket.getParkingLotId()).get(ticket.getTicketId()).setTicketStatus(TicketStatus.CLOSED);
            parkingTicketsMap.get(ticket.getParkingLotId()).get(ticket.getTicketId()).setUpdatedAt(LocalDateTime.now());
            return ticket;
        }
    }
}
