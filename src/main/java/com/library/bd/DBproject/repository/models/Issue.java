package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "issues")
@Data
public class Issue {
    @Id
    private String id;
    private String readerId; // Связь с читателем
    private String copyId; // Связь с экземпляром книги
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
