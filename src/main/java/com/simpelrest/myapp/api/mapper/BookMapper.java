package com.simpelrest.myapp.api.mapper;

import com.simpelrest.myapp.api.model.BookDTO;
import com.simpelrest.myapp.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);

    Book bookDtoToBook(BookDTO bookDTO);
}
