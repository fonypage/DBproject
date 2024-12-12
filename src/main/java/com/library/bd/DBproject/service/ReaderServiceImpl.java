package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.ReaderRepository;
import com.library.bd.DBproject.repository.models.Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService{
    private final ReaderRepository readerRepository;
    @Override
    public Optional<Reader> findReaderByFullName(String lastName, String firstName, String middleName) {
        return readerRepository.findByLastNameAndFirstNameAndMiddleName(lastName,firstName,middleName);
    }

    @Override
    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public Optional<Reader> findReaderById_(Integer id) {
        return readerRepository.findReaderById_(id);
    }

}
