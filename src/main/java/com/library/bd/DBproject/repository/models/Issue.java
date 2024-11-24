package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "issues")
@Data
public class Issue {
    @Id
    private ObjectId id;
    private ObjectId readerId; // Связь с читателем
    private ObjectId copyId; // Связь с экземпляром книги
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
