package com.library.bd.DBproject.repository.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "readers")
@Data
public class Reader {
    @Id
    private ObjectId id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String passportNumber;
    private String phone;
}


