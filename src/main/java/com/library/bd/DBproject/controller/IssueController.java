package com.library.bd.DBproject.controller;


import com.library.bd.DBproject.repository.models.Issue;
import com.library.bd.DBproject.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/issues")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody Map<String, Integer> requestData) {
        try {
            Integer readerId = requestData.get("readerId");
            Integer copyId = requestData.get("copyId");
            Issue issue = issueService.borrowBook(readerId, copyId);
            return new ResponseEntity<>(issue, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
