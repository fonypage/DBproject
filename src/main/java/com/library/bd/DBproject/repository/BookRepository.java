package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, Object> {
    Optional<List<Book>> findBooksByTitleContainsIgnoreCase(String title);

    List<Book> findByTitleContainingAndAuthorContainingAndGenreContaining(
            String title, String author, String genre);

    void deleteById_(Integer id);
    @Query("{'id_': ?0}")
    Optional<Book> findById_(Integer id);;


}

