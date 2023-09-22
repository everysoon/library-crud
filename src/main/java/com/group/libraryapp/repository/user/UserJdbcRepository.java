package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserJdbcRepository {
   private final JdbcTemplate jdbcTemplate;

   public void saveUser(String name, int age) {
      String sql = "insert into user (name,age) values (?,?) ";
      jdbcTemplate.update(sql, name, age);
   }

   public boolean isExistNotUser(Long userId) {
      String sql = "select * from user where id = ?";
      return jdbcTemplate.query(sql, (rs, num) -> 0, userId).isEmpty();
   }

   public boolean isExistNotUser(String name) {
      String sql = "select * from user where name = ?";
      return jdbcTemplate.query(sql, (rs, num) -> 0, name).isEmpty();
   }

   public void updateName(String name, Long userId) {
      String sql = "update user set name = ? where id = ?";
      jdbcTemplate.update(sql, name, userId);
   }

   public void deleteUser(String name) {
      String sql = "delete from user where name = ?";
      jdbcTemplate.update(sql, name);
   }

   public List<UserResponse> getUsers() {
      String sql = "select * from user";
      return jdbcTemplate.query(sql, userResponseRowMapper());
   }

   public RowMapper<UserResponse> userResponseRowMapper(){
      return (rs,num)->{
         long id = rs.getLong("id");
         String name = rs.getString("name");
         int age = rs.getInt("age");
         return new UserResponse(id, name, age);
      };
   }

   public UserResponse getUser(Long userId) {
      String sql = "select * from user where id = ?";
      return jdbcTemplate.queryForObject(sql, userResponseRowMapper(), userId );
   }
}
