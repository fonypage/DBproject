package com.library.bd.DBproject.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "readers")
public class Reader {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String passportNumber;
    private String phone;
}


