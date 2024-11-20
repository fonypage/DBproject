package com.library.bd.DBproject.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "copies")
public class Copy {
    @Id
    private String id;
    private String bookId; // Связь с книгой
    private String location;
}

