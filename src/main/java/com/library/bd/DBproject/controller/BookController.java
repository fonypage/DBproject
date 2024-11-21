package com.library.bd.DBproject.controller;

import com.library.bd.DBproject.dto.BookDetailsResponse;
import com.library.bd.DBproject.repository.models.Book;
import com.library.bd.DBproject.repository.models.Copy;
import com.library.bd.DBproject.service.BookService;
import com.library.bd.DBproject.service.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CopyService copyService;


    @PostMapping //todo
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping //todo
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooksByTitle(@RequestParam String title) {
        return bookService.findBooksByTitle(title)
                .map(books -> new ResponseEntity<>(books, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDetailsResponse> getBookDetails(@PathVariable String bookId) {
        Book book = bookService.getBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Книга не найдена"));

        List<Copy> copies = copyService.getCopiesByBookId(bookId);
        return ResponseEntity.ok(new BookDetailsResponse(book, copies));
    }
}
