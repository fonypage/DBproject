package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<List<Book>> findBooksByTitleContainsIgnoreCase(String title);

    List<Book> findByTitleContainingAndAuthorContainingAndGenreContaining(
            String title, String author, String genre);
}

