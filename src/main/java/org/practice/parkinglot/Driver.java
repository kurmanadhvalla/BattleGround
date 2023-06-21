package org.practice.parkinglot;

import org.practice.parkinglot.dao.IParkingLotManagementDao;
import org.practice.parkinglot.dao.IParkingTicketManagementDao;
import org.practice.parkinglot.dao.ParkingLotManagementDaoImpl;
import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.enums.VehicleType;
import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;
import org.practice.parkinglot.models.Ticket;
import org.practice.parkinglot.models.Vehicle;
import org.practice.parkinglot.services.IParkingLotManagementService;
import org.practice.parkinglot.services.IParkingService;
import org.practice.parkinglot.services.ParkingLotManagementServiceImpl;
import org.practice.parkinglot.services.ParkingServiceImpl;
import org.practice.parkinglot.strategies.AllocateFirstAvailableSlotStrategy;
import org.practice.parkinglot.strategies.IParkingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        IParkingLotManagementDao parkingLotManagementDao = new ParkingLotManagementDaoImpl();
        IParkingLotManagementService parkingLotManagementService = new ParkingLotManagementServiceImpl(parkingLotManagementDao);
        ParkingLot parkingLot = parkingLotManagementService.createParkingLot("parkinglot1","address1");
        Map<ParkingSlotType,Integer> capacityAndSlotTypeMap = new HashMap<>();
        capacityAndSlotTypeMap.put(ParkingSlotType.CAR,5);
        capacityAndSlotTypeMap.put(ParkingSlotType.BUS,5);
        capacityAndSlotTypeMap.put(ParkingSlotType.TRUCK,5);

        parkingLotManagementService.addFloor(parkingLot.getId(),  30,capacityAndSlotTypeMap );

        parkingLotManagementService.addParkingSlot(parkingLot.getId(),  1, ParkingSlotType.CAR );

        List<ParkingSlot> slots = parkingLotManagementService.getParkingSlots(parkingLot.getId(),1);

        for(ParkingSlot slot :slots){
            System.out.println(slot.getType() +" " +slot.getParkingSlotId());
        }
        IParkingTicketManagementDao parkingTicketManagementDao = new IParkingLotManagementDao.ParkingTicketManagementDaoImpl();
        IParkingStrategy parkingStrategy =new AllocateFirstAvailableSlotStrategy();
        IParkingService parkingService = new ParkingServiceImpl(parkingLotManagementService,parkingTicketManagementDao,parkingStrategy);
        Vehicle vehicle = new Vehicle("AP30E5307", VehicleType.CAR);
        Ticket ticket  = parkingService.parkVehicle(parkingLot.getId() ,vehicle);
        boolean unParked =  parkingService.unParkVehicle(ticket);
        Ticket ticket1  = parkingService.parkVehicle(parkingLot.getId() ,vehicle);
        Ticket ticket2  = parkingService.parkVehicle(parkingLot.getId() ,vehicle);
        Vehicle vehicle2 = new Vehicle("AP30E5308", VehicleType.BUS);
        Ticket ticket3  = parkingService.parkVehicle(parkingLot.getId() ,vehicle2);


    }

}
