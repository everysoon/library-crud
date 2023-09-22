package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceV2 {
   private final UserRepository userRepository;
   public void save(String name,int age){
      userRepository.save(new User(name,age));
   }
   public boolean isExistNotUser(Long id){
      return !userRepository.existsById(id);
   }
   public List<UserResponse> getUsers(){
      return userRepository.findAll().stream().map(User::toDto).collect(Collectors.toList());
   }
   public boolean isExistNotUser(String name){
      return !userRepository.existsByName(name);
   }
   public void delete(String name){
      User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);;
      userRepository.delete(user);
   }
   public void update(String name,Long id){
      User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
      user.update(name);
      userRepository.save(user);
   }
}
