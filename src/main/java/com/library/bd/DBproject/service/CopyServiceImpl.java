package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.CopyRepository;
import com.library.bd.DBproject.repository.models.Copy;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CopyServiceImpl implements CopyService {
    private final CopyRepository copyRepository;

    public List<Copy> getCopiesByBookId(String bookId) {
        ObjectId objectId = new ObjectId(bookId);
        return copyRepository.findByBookId(objectId);
    }

    @Override
    public Optional<Copy> getCopyById(String copyId) {
        return copyRepository.getCopyById(new ObjectId(copyId));
    }
}
