package com.comunication.fasto.controllers;

import com.comunication.fasto.model.Collections;
import com.comunication.fasto.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/users/create")
    public Collections userscreate(@RequestBody Collections collections) {
        Collections _collections = usersRepository.save(new Collections(collections.getId(),
                collections.getUsername(), collections.getPassword())) ;
        return _collections;
    }

}
