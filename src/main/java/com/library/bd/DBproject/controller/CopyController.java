package com.library.bd.DBproject.controller;

import com.library.bd.DBproject.repository.CopyRepository;
import com.library.bd.DBproject.repository.models.Book;
import com.library.bd.DBproject.repository.models.Copy;
import com.library.bd.DBproject.service.BookService;
import com.library.bd.DBproject.service.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/copies")
@RequiredArgsConstructor
public class CopyController {

    private final CopyService copyService;
    private final CopyRepository copyRepository;
    private final BookService bookService;

    @PostMapping("/form/new")
    public ResponseEntity<Copy> createCopy(@RequestBody Copy copy) {
        Integer IdValue=copyRepository.findAll().size() ;
        copy.setId_(IdValue+1);
        List<Book> bookList= bookService.getAllBooks().stream().sorted(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getId_().compareTo(o1.getId_());
            }
        }).collect(Collectors.toList());
        copy.setBookId_(bookList.get(0).getId_());
        Copy createdCopy = copyService.createCopy(copy);
        return new ResponseEntity<>(createdCopy, HttpStatus.CREATED);
    }
}
