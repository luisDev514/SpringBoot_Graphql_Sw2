package com.graphl.flight.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "beds")
public class Bed {
    @Id
    private String id;
    private String title;
    private String service;

}
