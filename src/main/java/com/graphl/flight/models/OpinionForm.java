package com.graphl.flight.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "opinionforms")
public class OpinionForm {

    @Id
    private String id;
    private Boolean state;
    private String origin;
    private String destination;
    private String accommodationName;
    private String tripOpinion;
    private String destinyOpinion;
    private String reasonTrip;
    private String IdUser;
    private User user;
}
