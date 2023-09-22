package com.group.libraryapp.repository;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory,Long> {
   boolean existsByBookAndIsReturn(Book book, boolean isReturn);
   Optional<UserLoanHistory> findByUserAndBook(User user, Book book);
}
