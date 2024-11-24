package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Copy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends MongoRepository<Copy, String> {
    List<Copy> findByBookId(ObjectId bookId);
    Optional<Copy> getCopyById(ObjectId copyId);
}

