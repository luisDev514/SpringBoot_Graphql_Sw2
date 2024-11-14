package com.graphl.flight.graphql;

import lombok.Data;

import java.util.List;

@Data
public class InputAccomodation {
    private String id;
    private Number attention_number;
    private String company;
    private String imageUrl;
    private String owner;
    private String coordinates;
    private Number stars;
    private String description;
    private String schedule;
    private String page;
    private Number quantity;
    private String description_services;
    private List<String> typeRoom;
    private String instagramUrl;
    private String facebookUrl;
    private String webUrl;
    private String idUser;


}
