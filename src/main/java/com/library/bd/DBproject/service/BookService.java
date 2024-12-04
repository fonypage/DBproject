package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.models.Book;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);

   List<Book> getAllBooks();
    List<Book> getBooksByReaderId(Integer readerId);


    Optional<List<Book>> findBooksByTitle(String title);

    List<Book> searchBooks(String title, String author, String genre);
     Optional<Book> getBookById(Integer bookId);
     void deleteBook(Integer id);
}
