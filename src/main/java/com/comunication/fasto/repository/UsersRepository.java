package com.comunication.fasto.repository;

import com.comunication.fasto.model.Collections;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UsersRepository extends MongoRepository<Collections, String> {
    Collections findByUsername(String username);
}
