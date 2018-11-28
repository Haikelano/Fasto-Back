package com.comunication.fasto.controllers;

import com.comunication.fasto.model.Collections;
import com.comunication.fasto.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
   @Autowired
    UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Collections collections;
    @PostMapping("/user")
    public Collections user(@RequestBody Collections collections) {
        String hashPW=bCryptPasswordEncoder.encode(collections.getPassword());
        collections.setPassword(hashPW);
        Collections _collections = usersRepository.save(new Collections(collections.getId(),
                collections.getUsername(), collections.getPassword())) ;
        return _collections;
    }

}
