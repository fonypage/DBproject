package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.models.Copy;

import java.util.List;

public interface CopyService {
    List<Copy> getCopiesByBookId(String bookId);
}
