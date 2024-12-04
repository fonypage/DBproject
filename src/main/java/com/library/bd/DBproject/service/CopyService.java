package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.models.Copy;

import java.util.List;
import java.util.Optional;

public interface CopyService {
    List<Copy> getCopiesByBookId(Integer bookId);
    Copy createCopy(Copy copy);
    Optional<Copy> getCopyById(Integer copyId);
}
