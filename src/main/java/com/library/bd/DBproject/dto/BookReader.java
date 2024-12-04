package com.library.bd.DBproject.dto;

import com.library.bd.DBproject.repository.models.Book;
import com.library.bd.DBproject.repository.models.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;
@Data
@AllArgsConstructor
public class BookReader {
    private Reader reader;
    private List<Book> bookList;
}
