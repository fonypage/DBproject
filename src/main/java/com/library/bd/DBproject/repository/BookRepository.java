package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {}

