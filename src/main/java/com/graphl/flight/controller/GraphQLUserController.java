package com.graphl.flight.controller;

import com.graphl.flight.models.User;
import com.graphl.flight.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*")
public class GraphQLUserController {

    @Autowired
    private IUserService userService;

    @QueryMapping(name= "findUserById")
    public User findUserById(@Argument(name = "userId") String id){
        String userId = id;
        return userService.findById(userId);
    }
}
