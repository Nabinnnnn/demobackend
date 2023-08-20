package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void signUp(User user) {
        userRepository.save(user);
    }

    public String login(String email,String password) {

      Optional<User> userFromDB =  userRepository.findByEmailAndPassword(email,password);
      if(userFromDB.isPresent()){
          return "Success.";
      }
      else{
          return "Failed due to invalid email or password.";
      }
    }
}
