package com.group.libraryapp.repository.book;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookMemoryRepository {
   private final JdbcTemplate jdbcTemplate;

   public BookMemoryRepository(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }
   public void save(String name){
      String sql ="insert into book(book_name,price) values(?,0)";
      jdbcTemplate.update(sql,name);
   }
}
