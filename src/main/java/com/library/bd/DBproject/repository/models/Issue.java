package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "issues")
@Data
public class Issue {
    @Id
    private ObjectId id;
    private Integer id_;
    private Integer readerId_;
    private Integer copyId_;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
