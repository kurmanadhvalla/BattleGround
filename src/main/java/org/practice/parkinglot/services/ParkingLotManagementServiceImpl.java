package org.practice.parkinglot.services;

import org.practice.parkinglot.dao.IParkingLotManagementDao;
import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;

import java.util.List;
import java.util.Map;

public class ParkingLotManagementServiceImpl implements IParkingLotManagementService {

    private final IParkingLotManagementDao parkingLotManagementDao;

    public ParkingLotManagementServiceImpl(IParkingLotManagementDao parkingLotManagementDao) {
        this.parkingLotManagementDao = parkingLotManagementDao;
    }

    @Override
    public ParkingLot createParkingLot(String name, String address) {
        ParkingLot  parkingLot  =  parkingLotManagementDao.createParkingLot(name,address);
        return parkingLot;
    }

    @Override
    public boolean addFloor(String parkingLotId, int capacity, Map<ParkingSlotType, Integer> capacityAndSlotTypeMap) {

        return parkingLotManagementDao.addFloor(parkingLotId,capacity,capacityAndSlotTypeMap);
    }

    @Override
    public ParkingSlot addParkingSlot(String parkingLotId, int floorId, ParkingSlotType type) {
        return parkingLotManagementDao.addParkingSlot(parkingLotId,floorId,type);
    }

    @Override
    public List<ParkingSlot> getParkingSlots(String parkingLotId, int floorId) {
         return parkingLotManagementDao.getParkingSlots(parkingLotId,floorId);
    }

    @Override
    public ParkingLot getParkingLotById(String parkingLotId) {
        return parkingLotManagementDao.getParkingLotById(parkingLotId);
    }
}
