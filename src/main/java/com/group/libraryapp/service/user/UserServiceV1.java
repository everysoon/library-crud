package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.request.user.RequestUser;
import com.group.libraryapp.dto.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceV1 {
   private final UserJdbcRepository userJdbcRepository;
   public void updateUser(RequestUser param){
      if(userJdbcRepository.isExistNotUser(param.getId())){
         throw new IllegalArgumentException("param get Id invalid");
      }
      userJdbcRepository.updateName(param.getName(), param.getId());
   }
   public void deleteUser(RequestUser param){
      if(userJdbcRepository.isExistNotUser(param.getName())){
         throw new IllegalArgumentException("param get name invalid");
      }
      userJdbcRepository.deleteUser(param.getName());
   }
   public List<UserResponse> getUsers(){
      return userJdbcRepository.getUsers();
   }
   public UserResponse getUser(Long id){
      return userJdbcRepository.getUser(id);
   }
   public void saveUser(String name,int age){
      userJdbcRepository.saveUser(name,age);
   }
}
