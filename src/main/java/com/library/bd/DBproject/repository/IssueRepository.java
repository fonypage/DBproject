package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssueRepository extends MongoRepository<Issue, String> {}

