package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Copy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CopyRepository extends MongoRepository<Copy, String> {
    List<Copy> findByBookId(ObjectId bookId);
}

