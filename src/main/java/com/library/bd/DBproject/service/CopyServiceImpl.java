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

    public List<Copy> getCopiesByBookId(Integer bookId) {
        return copyRepository.findByBookId(bookId);
    }
    public Copy createCopy(Copy copy){
        return copyRepository.save(copy);
    }

    @Override
    public Optional<Copy> getCopyById(Integer copyId) {
        return copyRepository.getCopyById((copyId));
    }
}
