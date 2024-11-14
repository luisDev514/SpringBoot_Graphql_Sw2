package com.graphl.flight.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "offers")
public class Offer {

    @Id
    private String id;
    private String title;
    private Number price;
    private Number discount;
    private String imageUrl;
    private Number beds;
    private String descriptionServices;
    private List<String> typeRoom;
    private String state;
    private String idAccomodation;
    private Accomodation accomodation;
}
