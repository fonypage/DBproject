package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends MongoRepository<Reader, String> {
    Optional<Reader> findByLastNameAndFirstNameAndMiddleName(String lastName, String firstName, String middleName);

    @Query("{ 'id_': ?0 }")
    Optional<Reader> findReaderById_(Integer readerId);
}
