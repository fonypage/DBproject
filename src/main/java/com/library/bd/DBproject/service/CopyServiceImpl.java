package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.CopyRepository;
import com.library.bd.DBproject.repository.models.Copy;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyServiceImpl implements CopyService {
    private final CopyRepository copyRepository;

    public List<Copy> getCopiesByBookId(String bookId) {
        ObjectId objectId = new ObjectId(bookId);
        return copyRepository.findByBookId(objectId);
    }
}
