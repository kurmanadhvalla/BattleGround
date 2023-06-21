package org.practice.libraryManagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookCopy {
    private final String copyId;
    private final Book book;
    private final String libraryId;
    private int rackId;

}
