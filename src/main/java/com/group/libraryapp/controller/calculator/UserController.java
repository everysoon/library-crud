package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.request.user.RequestUser;
import com.group.libraryapp.dto.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
   private final UserServiceV1 userServiceV1;

   @DeleteMapping
   public void delete(RequestUser param){
      userServiceV1.deleteUser(param);
   }
   @PutMapping
   public void update(RequestUser param){
      userServiceV1.updateUser(param);
   }
   @GetMapping("{userId}")
   public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
      return ResponseEntity.ok(userServiceV1.getUser(userId));
   }
   @GetMapping
   public ResponseEntity<List<UserResponse>> getUsers(){
      return ResponseEntity.ok(userServiceV1.getUsers());
   }
}
