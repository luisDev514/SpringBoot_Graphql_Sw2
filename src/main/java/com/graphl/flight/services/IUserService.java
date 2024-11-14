package com.graphl.flight.services;

import com.graphl.flight.models.Offer;
import com.graphl.flight.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService  {
    User register(User user);

    User findById(String id);

    User login(String email, String password);
}
