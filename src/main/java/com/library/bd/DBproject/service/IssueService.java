package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.models.Issue;

public interface IssueService {
    Issue borrowBook(Integer readerId, Integer copyId);
}
