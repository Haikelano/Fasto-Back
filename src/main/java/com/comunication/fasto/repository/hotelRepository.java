package com.comunication.fasto.repository;

import com.comunication.fasto.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface hotelRepository extends MongoRepository<Hotel, String> {
}
