package org.practice.libraryManagement.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Library {
    private final String id;
    private final String name;
    private final List<Rack> racks;

    public Library(String id, String name) {
        this.id = id;
        this.name = name;
        this.racks = new ArrayList<>();
    }
}
