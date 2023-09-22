package com.group.libraryapp.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false,length = 255)
   private String name;

   public Book(String name){
      if(StringUtils.isEmpty(name)) throw new IllegalArgumentException("잘못된 name이 들어왔습니다.");
      this.name = name;
   }
}
