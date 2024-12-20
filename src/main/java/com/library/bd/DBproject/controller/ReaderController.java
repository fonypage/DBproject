package com.library.bd.DBproject.controller;


import com.library.bd.DBproject.dto.BookReader;
import com.library.bd.DBproject.repository.ReaderRepository;
import com.library.bd.DBproject.repository.models.Book;
import com.library.bd.DBproject.repository.models.Reader;
import com.library.bd.DBproject.service.BookService;
import com.library.bd.DBproject.service.IssueService;
import com.library.bd.DBproject.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    private final ReaderRepository readerRepository;
    private final BookService bookService;

    private final IssueService issueService;

    @GetMapping(value = "/search")
    public ResponseEntity<BookReader> findReader(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String middleName) {
        Reader reader = readerService.findReaderByFullName(lastName, firstName, middleName).orElseThrow(() -> new RuntimeException("Reader not found with name: "
                + lastName + " " + firstName + " " + middleName));
        List<Book>bookList=bookService.getBooksByReaderId(reader.getId_());
        BookReader bookReader =new BookReader(reader,bookList);

        return new ResponseEntity<>(bookReader,HttpStatus.OK);
    }

    @PostMapping(value = "/form/new")
    public ResponseEntity<?> createReader(@RequestBody Reader reader){
        Integer idValue=readerRepository.findAll().size();
        reader.setId_(idValue+1);
        Reader savedReader = readerService.createReader(reader);
        return new ResponseEntity<>(savedReader,HttpStatus.CREATED);
    }
    @DeleteMapping("/{readerId}/books/{bookId}")
    public ResponseEntity<?> returnBookFromReader(@PathVariable Integer readerId, @PathVariable Integer bookId) {
        // проверяем, существует ли читатель
        readerService.findReaderById_(readerId)
                .orElseThrow(() -> new RuntimeException("Reader not found with id: " + readerId));

        // проверяем, существует ли книга
        bookService.getBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        // Возвращаем книгу (удаляем Issue)
        issueService.returnBook(readerId, bookId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
