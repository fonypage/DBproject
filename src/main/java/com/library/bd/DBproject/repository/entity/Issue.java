package com.library.bd.DBproject.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "issues")
public class Issue {
    @Id
    private String id;
    private String readerId; // Связь с читателем
    private String copyId; // Связь с экземпляром книги
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
