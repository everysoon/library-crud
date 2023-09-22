package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserLoanHistory;
import com.group.libraryapp.dto.request.book.RequestBook;
import com.group.libraryapp.dto.request.book.RequestLoanBook;
import com.group.libraryapp.repository.UserLoanHistoryRepository;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BookService {
   private final BookRepository bookRepository;
   private final UserRepository userRepository;
   private final UserLoanHistoryRepository loanHistoryRepository;

   @Transactional
   public void saveBook(RequestBook param) {
      bookRepository.save(new Book(param.getName()));
   }

   @Transactional
   public void loanBook(RequestLoanBook param) {
      User user = userRepository.findByName(param.getUserName()).orElseThrow(IllegalAccessError::new);
      Book book = bookRepository.findByName(param.getBookName()).orElseThrow(IllegalAccessError::new);
      boolean isRent = loanHistoryRepository.existsByBookAndIsReturn(book,false);
      if (isRent) {
         System.out.println("대여중");
         return;
      }
      user.loanBook(book.getName());
//      loanHistoryRepository.save(new UserLoanHistory(user, book));
   }
   @Transactional
   public void returnBook(RequestLoanBook param){
      User user = userRepository.findByName(param.getUserName()).orElseThrow(IllegalAccessError::new);
      user.returnBook(param.getBookName());
   }
}
