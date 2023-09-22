package com.group.libraryapp.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserLoanHistory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User user;

   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name = "book_name",referencedColumnName = "name")
   private Book book;
   @Column(columnDefinition = "TINYINT",name = "is_return")
   private boolean isReturn;

   public UserLoanHistory(User user,Book book){
      this.user = user;
      this.book = book;
      this.isReturn = false;
   }

   public void doReturn() {
      this.isReturn = true;
   }
   public String getBookName(){
      return this.book.getName();
   }
}
