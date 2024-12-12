package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.IssueRepository;
import com.library.bd.DBproject.repository.models.Copy;
import com.library.bd.DBproject.repository.models.Issue;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        issue.setId_(idValue+1);
        issue.setCopyId_(copyId);
        issue.setBorrowDate(LocalDate.now());
        issue.setReturnDate(null);

        return issueRepository.save(issue);
    }

    @Override
    public void returnBook(Integer readerId, Integer bookId) {
        // 1. Получаем все экземпляры книги по bookId
        List<Copy> copies = copyService.getCopiesByBookId(bookId);

        // 2. Получаем из них список их id_
        List<Integer> copyIds = copies.stream()
                .map(Copy::getId_)
                .toList();

        // 3. Находим все Issue по readerId и copyId_ из списка
        List<Issue> issuesToDelete = issueRepository.findAllByReaderId(readerId).stream()
                .filter(issue -> copyIds.contains(issue.getCopyId_()))
                .toList();

        // 4. Удаляем найденные Issue
        issueRepository.deleteAll(issuesToDelete);
    }

//    @Override
//    public boolean isCopyAlreadyBorrowed(String copyId) {
//        return issueRepository.existsByCopyIdAndReturnDateIsNull(new ObjectId(copyId));
//    }
}
