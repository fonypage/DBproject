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
    public Issue borrowBook(Integer readerId, Integer copyId) {
        Integer idValue=issueRepository.findAll().size();
        Copy copy = copyService.getCopyById(copyId)
                .orElseThrow(() -> new RuntimeException("Экземпляр книги не найден"));

        Issue issue = new Issue();
        issue.setReaderId_(readerId);
        issue.setCopyId_(copyId);
        issue.setBorrowDate(LocalDate.now());
        issue.setReturnDate(null);

        return issueRepository.save(issue);
    }

//    @Override
//    public boolean isCopyAlreadyBorrowed(String copyId) {
//        return issueRepository.existsByCopyIdAndReturnDateIsNull(new ObjectId(copyId));
//    }
}
