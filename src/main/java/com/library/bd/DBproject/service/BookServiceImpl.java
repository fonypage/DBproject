package com.library.bd.DBproject.service;

import com.library.bd.DBproject.repository.BookRepository;
import com.library.bd.DBproject.repository.models.Book;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import com.library.bd.DBproject.repository.models.*;

import java.util.List;
import java.util.Optional;
import com.library.bd.DBproject.repository.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final CopyService copyService;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByReaderId(Integer readerId) {
        // 1. Получаем все записи Issue для данного readerId
        List<Issue> issues = issueRepository.findAllByReaderId(readerId);

        // 2. Извлекаем copyId_ из каждой записи Issue
        List<Integer> copyIds = issues.stream()
                .map(Issue::getCopyId_)
                .toList();

        // 3. Для каждого copyId находим соответствующий экземпляр книги (Copy)
        List<Copy> copies = copyIds.stream()
                .map(copyId -> copyService.getCopyById(copyId).orElse(null))
                .filter(copy -> copy != null)
                .toList();

        // 4. Извлекаем bookId_ из каждой записи Copy
        List<Integer> bookIds = copies.stream()
                .map(Copy::getBookId_)
                .distinct()
                .toList();

        // 5. Для каждого bookId находим книгу
        List<Book> books = bookIds.stream()
                .map(bookId -> bookRepository.findById_(bookId).orElse(null))
                .filter(book -> book != null)
                .toList();

        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<List<Book>> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitleContainsIgnoreCase(title);
    }

    @Override
    public void deleteBook(Integer id) {
        Optional<Book> book = bookRepository.findById_(id);
        if (book.isPresent()) {
            Book now=book.get();
            bookRepository.delete(now);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    public List<Book> searchBooks(String title, String author, String genre) {
        if ((title == null || title.isEmpty()) &&
                (author == null || author.isEmpty()) &&
                (genre == null || genre.isEmpty())) {
            return getAllBooks(); // Если параметры пустые, возвращаем все книги
        }

        return bookRepository.findByTitleContainingAndAuthorContainingAndGenreContaining(
                title != null ? title : "",
                author != null ? author : "",
                genre != null ? genre : ""
        );
    }
    public Optional<Book> getBookById(Integer bookId) {
       return bookRepository.findById_(bookId);
    }
}
