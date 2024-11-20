package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book {
    @Id
    private String id;
    private String author;
    private String title;
    private String genre;
    private int publicationYear;
    private String publisher;
    private double price;
}
