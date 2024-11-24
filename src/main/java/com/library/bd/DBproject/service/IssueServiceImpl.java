package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.IssueRepository;
import com.library.bd.DBproject.repository.models.Copy;
import com.library.bd.DBproject.repository.models.Issue;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService{
    private final IssueRepository issueRepository;
    private final CopyService copyService;

    @Override
    public Issue borrowBook(String readerId, String copyId) {
        ObjectId objectIdReader = new ObjectId(readerId);
        ObjectId objectIdCopy = new ObjectId(copyId);
        Copy copy = copyService.getCopyById(copyId)
                .orElseThrow(() -> new RuntimeException("Экземпляр книги не найден"));
        if(isCopyAlreadyBorrowed(copyId)){
            throw new RuntimeException("Экземпляр уже выдан");
        }

        Issue issue = new Issue();
        issue.setReaderId(objectIdReader);
        issue.setCopyId(objectIdCopy);
        issue.setBorrowDate(LocalDate.now());
        issue.setReturnDate(null);

        return issueRepository.save(issue);
    }

    @Override
    public boolean isCopyAlreadyBorrowed(String copyId) {
        return issueRepository.existsByCopyIdAndReturnDateIsNull(new ObjectId(copyId));
    }
}
