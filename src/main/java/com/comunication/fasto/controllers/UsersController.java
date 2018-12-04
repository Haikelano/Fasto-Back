package com.comunication.fasto.controllers;

import com.comunication.fasto.model.Users;
import com.comunication.fasto.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UsersController {
   @Autowired
    UsersRepository usersRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;
    private Users users;

    @PostMapping("/register")
    public Users user(@RequestBody Users users) {
        String encryptpassword = passwordEncoder.encode(users.getPassword());
         Users _users = usersRepository.save(new Users(users.getId(),
                users.getUsername(), passwordEncoder.encode(users.getPassword())));
         return _users;
    }
 @RequestMapping("/login")
 public boolean login(@RequestBody Users users) {
  System.out.println("ok haykel");
     System.out.println("username "+users.getUsername());
  return users.getUsername().equals("username") && users.getPassword().equals("password");
 }
}
