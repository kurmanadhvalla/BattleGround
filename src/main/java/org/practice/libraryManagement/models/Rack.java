package org.practice.libraryManagement.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Rack {
    private final int rackId;
    private int capacity;
    private final Map<String, BookCopy> books;

    public Rack(int rackId, int capacity) {
        this.rackId = rackId;
        this.capacity = capacity;
        books =new HashMap<>();
    }

}
