package com.simpelrest.myapp.repositories;

import com.simpelrest.myapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
