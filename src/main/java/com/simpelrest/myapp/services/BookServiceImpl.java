package com.simpelrest.myapp.services;

import com.simpelrest.myapp.api.mapper.BookMapper;
import com.simpelrest.myapp.api.model.BookDTO;
import com.simpelrest.myapp.domain.Book;
import com.simpelrest.myapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper){
        this.bookMapper = bookMapper;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks(){
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO createNewBook(BookDTO bookDTO){
        Book book = bookMapper.bookDtoToBook(bookDTO);

        Book savedBook = bookRepository.save(book);

        BookDTO returnDto = bookMapper.bookToBookDTO(savedBook);

        return returnDto;
    }
}
