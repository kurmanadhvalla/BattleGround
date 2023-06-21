package org.practice.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Getter
@Setter
public class ParkingLot {
    private final String id;
    private final String name;

    private final String address;

    private final List<Floor> floors;

    public ParkingLot(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.floors =new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }
}
