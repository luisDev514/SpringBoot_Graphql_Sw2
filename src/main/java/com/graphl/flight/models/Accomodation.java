package com.graphl.flight.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "accomodations")
public class Accomodation {
    @Id
    private String id;
    private Number attention_number;
    private String imageUrl;
    private String company;
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
