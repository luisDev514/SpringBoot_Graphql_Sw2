package com.graphl.flight.graphql;

import lombok.Data;

import java.util.List;
@Data
public class InputOffer {
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
    private InputAccomodation accomodation;
}
