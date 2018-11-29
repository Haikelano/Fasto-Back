package com.comunication.fasto.repository;

import com.comunication.fasto.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends MongoRepository<Users, Long> {
    Users findByUsername(String username);
    Boolean existsByUsername(String username);

}
