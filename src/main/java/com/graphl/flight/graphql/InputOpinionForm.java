package com.graphl.flight.graphql;

import com.graphl.flight.models.User;
import lombok.Data;

@Data
public class InputOpinionForm {
    private String id;
    private Boolean state;
    private String origin;
    private String destination;
    private String accommodationName;
    private String tripOpinion;
    private String destinyOpinion;
    private String reasonTrip;
    private String idUser;
    private User user;
}
