package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("users")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user){
        userService.signUp(user);
        return ResponseEntity.ok("Success.");

    }
    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();
        String message = userService.login(email, password);

        return ResponseEntity.ok(message);
    }
}
