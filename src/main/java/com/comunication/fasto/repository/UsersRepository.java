package com.comunication.fasto.repository;

import com.comunication.fasto.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
/*@RepositoryRestController*/
public interface UsersRepository extends MongoRepository<Users, Long> {
    Users findByUsername(String username);
    List<Users> findAll();
    Boolean existsByUsername(String username);

}
