package com.library.bd.DBproject.controller;

import com.library.bd.DBproject.repository.models.Reader;
import com.library.bd.DBproject.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping(value = "/search")
    public ResponseEntity<Reader> findReader(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String middleName) {
        return readerService.findReaderByFullName(lastName, firstName, middleName)
                .map(reader -> new ResponseEntity<>(reader, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> createReader(@RequestBody Reader reader){
        Reader savedReader = readerService.createReader(reader);
        return new ResponseEntity<>(savedReader,HttpStatus.CREATED);
    }

}
