package com.graphl.flight.services.implementation;


import com.graphl.flight.models.User;
import com.graphl.flight.models.User;
import com.graphl.flight.repository.IUserDAO;
import com.graphl.flight.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        User existingUser = userDAO.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.save(user);
    }

    @Override
    public User findById(String id) {
        return userDAO.findById(id).orElseThrow();
    }


    @Override
    public User login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new UsernameNotFoundException("Invalid login credentials");
    }

}
