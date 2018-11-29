package com.comunication.fasto.repository;

import com.comunication.fasto.model.Collections;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends MongoRepository<Collections, Long> {
    Collections findByUsername(String username);
    Boolean existsByUsername(String username);

}
