package com.library.bd.DBproject.repository;

import com.library.bd.DBproject.repository.models.Copy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CopyRepository extends MongoRepository<Copy, String> {}

