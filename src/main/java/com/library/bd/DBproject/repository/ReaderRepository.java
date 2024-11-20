package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.entity.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {
}
