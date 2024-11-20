package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.models.Reader;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ReaderService  {
    Optional<Reader> findReaderByFullName(String lastName, String firstName, String middleName);
}
