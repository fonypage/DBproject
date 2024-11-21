package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.CopyRepository;
import com.library.bd.DBproject.repository.models.Copy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyServiceImpl {
    private final CopyRepository copyRepository;

    public List<Copy> getCopiesByBookId(String bookId) {
        return copyRepository.findByBookId(bookId);
    }
}
