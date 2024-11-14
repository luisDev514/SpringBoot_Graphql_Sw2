package com.graphl.flight.repository;

import com.graphl.flight.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserDAO extends MongoRepository<User, String> {
    User findByEmail(String email);


}
