package com.graphl.flight.repository;


import com.graphl.flight.models.Accomodation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IAccomodationDAO extends MongoRepository<Accomodation, String> {
    List<Accomodation> findByIdUser(String idUser);

}
