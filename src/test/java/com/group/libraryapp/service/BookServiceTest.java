package com.group.libraryapp.service;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.request.book.RequestLoanBook;
import com.group.libraryapp.repository.book.BookMemoryRepository;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserRepository;
import com.group.libraryapp.service.book.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.group.libraryapp.config.DBConfig.*;

@SpringBootTest
class BookServiceTest {
   @Autowired
   private BookRepository bookRepository;
   @Autowired
   private BookService bookService;
   @Autowired
   private UserRepository userRepository;

   @Test
   public void addBook(){
//      User soon1 = new User("soon1",27);
//      User soon2 = new User("soon2",27);
//      userRepository.save(soon1);
//      userRepository.save(soon2);
//      Book book = new Book("내가읽을책");
//      bookRepository.save(book);
//      RequestLoanBook param = new RequestLoanBook("soon2","내가읽을책");
//      bookService.loanBook(param);

   }
}