package com.group.libraryapp.domain;

import com.group.libraryapp.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // protected 기본생성자가 필요
@Getter
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // primary Key 자동생성
   private Long id;

   @Column(nullable = false, length = 20)
   private String name;
   private int age;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   List<UserLoanHistory> histories = new ArrayList<>();

   public User(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public void update(String name) {
      this.name = name;
   }

   public UserResponse toDto() {
      return new UserResponse(id, name, age);
   }
   public void loanBook(String bookName){
      this.histories.add(new UserLoanHistory(this,new Book(bookName)));
   }
   public void returnBook(String bookName){
      UserLoanHistory userLoanHistory = this.histories.stream().findFirst().filter(h->h.getBookName().equals(bookName)).orElseThrow(IllegalAccessError::new);
      userLoanHistory.doReturn();
   }
}

