package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "copies")
@Data
public class Copy {
    @Id
    private ObjectId id;
    private ObjectId bookId; // Связь с книгой
    private String location;
}

