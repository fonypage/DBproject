package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Issue;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {
//    boolean existsByCopyIdAndReturnDateIsNull(Integer copyId);
}

