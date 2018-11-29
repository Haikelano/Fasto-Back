package com.comunication.fasto.controllers;

import com.comunication.fasto.model.Users;
import com.comunication.fasto.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
   @Autowired
    UsersRepository usersRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Users users;

    @PostMapping("/user")
    public Users user(@RequestBody Users users) {
        String hashPW=bCryptPasswordEncoder.encode(users.getPassword());
        users.setPassword(hashPW);
        Users _users = usersRepository.save(new Users(users.getId(),
                users.getUsername(), users.getPassword())) ;
        return _users;
    }

}
