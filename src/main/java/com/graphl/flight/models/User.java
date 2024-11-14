package com.graphl.flight.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;


    public String getPassword() {
        return password;
    }



    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }


    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }






}
