package org.practice.parkinglot.dao;

import org.practice.parkinglot.enums.ParkingSlotType;
import org.practice.parkinglot.models.Floor;
import org.practice.parkinglot.models.ParkingLot;
import org.practice.parkinglot.models.ParkingSlot;

import java.util.*;

public class ParkingLotManagementDaoImpl implements IParkingLotManagementDao{

    private final Map<String,ParkingLot> parkingLots;

    public ParkingLotManagementDaoImpl(){
        this.parkingLots= new HashMap<>();
    }
    @Override
    public ParkingLot createParkingLot(String name, String address) {

        ParkingLot  parkingLot = new ParkingLot(UUID.randomUUID().toString(),name,address);
        parkingLots.put(parkingLot.getId() ,parkingLot);
        return parkingLot;
    }

    @Override
    public boolean addFloor(String parkingLotId, int capacity, Map<ParkingSlotType, Integer> capacityAndSlotTypeMap) {

        ParkingLot parkingLot  =  getParkingLotById(parkingLotId);
        int floors  =parkingLot.getFloors().size();
        Floor floor  = new Floor(floors+1,capacity);
        int index=1;
        for(Map.Entry<ParkingSlotType,Integer>  entry : capacityAndSlotTypeMap.entrySet()){
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for(int  i=1;i<=entry.getValue();i++){
                parkingSlots.add(new ParkingSlot(index++,entry.getKey(), floor.getFloorId(), parkingLotId));
            }
            floor.getParkingSlots().put(entry.getKey(),parkingSlots);
        }
        parkingLot.getFloors().add(floor);
        return true;
    }

    @Override
    public ParkingLot getParkingLotById(String parkingLotId) {
        if(parkingLots.get(parkingLotId)!=null)
            return  parkingLots.get(parkingLotId);
        return null;
    }

    @Override
    public ParkingSlot addParkingSlot(String parkingLotId, int floorId, ParkingSlotType type) {
        ParkingLot parkingLot = getParkingLotById(parkingLotId);
        List<ParkingSlot> slots = parkingLot.getFloors().get(floorId-1).getParkingSlots().getOrDefault(type,new ArrayList<>());
        ParkingSlot slotTobeAdded = new ParkingSlot(slots.size() + 1, type, floorId, parkingLotId);
        slots.add(slotTobeAdded);
        parkingLot.getFloors().get(floorId-1).getParkingSlots().put(type,slots);
        return slotTobeAdded;
    }

    @Override
    public List<ParkingSlot> getParkingSlots(String parkingLotId, int floorId) {
        ParkingLot parkinglot = getParkingLotById(parkingLotId);
        final List<ParkingSlot> slots = new ArrayList<>();
        Floor floor  =parkinglot.getFloors().get(floorId - 1);
        for (List<ParkingSlot> parkingSlots : floor.getParkingSlots().values()) {
            slots.addAll(parkingSlots);
        }
        return slots;
    }
}
