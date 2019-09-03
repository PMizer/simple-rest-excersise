package com.simpelrest.myapp.services;

import com.simpelrest.myapp.api.model.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO createNewBook(BookDTO bookDTO);
}
