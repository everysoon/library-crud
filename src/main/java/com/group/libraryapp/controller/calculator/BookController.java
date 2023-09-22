package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.request.book.RequestBook;
import com.group.libraryapp.dto.request.book.RequestLoanBook;
import com.group.libraryapp.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
@RequiredArgsConstructor
public class BookController {
   private final BookService bookService;
   @PostMapping
   public ResponseEntity<?> saveBook(@RequestBody RequestBook param){
      bookService.saveBook(param);
      return ResponseEntity.ok().build();
   }
   @PostMapping("/loan")
   public ResponseEntity<?> loanBook(@RequestBody RequestLoanBook param){
      bookService.loanBook(param);
      return ResponseEntity.ok().build();
   }
   @PutMapping("/loan")
   public void returnBook(@RequestBody RequestLoanBook param){
      bookService.returnBook(param);
   }

}
