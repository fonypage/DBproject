package com.library.bd.DBproject.dto;

import com.library.bd.DBproject.repository.models.Book;
import com.library.bd.DBproject.repository.models.Copy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDetailsResponse {
    private Book book; // Информация о книге
    private List<Copy> copies; // Местоположение экземпляров
}
