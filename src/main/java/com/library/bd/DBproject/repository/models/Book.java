package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book {
    @Id
    private ObjectId id;
    private  Integer id_;
    private String author;
    private String title;
    private String genre;
    private int publicationYear;
    private String publisher;
    private double price;
}
