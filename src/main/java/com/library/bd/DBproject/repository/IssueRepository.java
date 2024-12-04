package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Issue;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {
    //    boolean existsByCopyIdAndReturnDateIsNull(Integer copyId);
    @Query("{ 'readerId_': ?0 }")
    List<Issue> findAllByReaderId(Integer readerId_);
}

