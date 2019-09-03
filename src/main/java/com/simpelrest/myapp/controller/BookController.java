package com.simpelrest.myapp.controller;

import com.simpelrest.myapp.api.model.BookDTO;
import com.simpelrest.myapp.api.model.BookListDTO;
import com.simpelrest.myapp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public ResponseEntity<BookListDTO> getListOfBooks(){

        return new ResponseEntity<BookListDTO>(new BookListDTO(bookService.getAllBooks()),
                HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> createNewBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<BookDTO>(bookService.createNewBook(bookDTO),
                HttpStatus.CREATED);
    }
}
