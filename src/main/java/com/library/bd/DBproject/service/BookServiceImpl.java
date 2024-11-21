package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.BookRepository;
import com.library.bd.DBproject.repository.models.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<List<Book>> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitleContainsIgnoreCase(title);
    }

    public List<Book> searchBooks(String title, String author, String genre) {
        if ((title == null || title.isEmpty()) &&
                (author == null || author.isEmpty()) &&
                (genre == null || genre.isEmpty())) {
            return getAllBooks(); // Если параметры пустые, возвращаем все книги
        }

        return bookRepository.findByTitleContainingAndAuthorContainingAndGenreContaining(
                title != null ? title : "",
                author != null ? author : "",
                genre != null ? genre : ""
        );
    }
    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findById(bookId);
    }
}
