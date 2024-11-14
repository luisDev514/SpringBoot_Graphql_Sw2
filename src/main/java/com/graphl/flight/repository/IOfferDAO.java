package com.graphl.flight.repository;

import com.graphl.flight.models.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOfferDAO extends MongoRepository<Offer, String> {
    List<Offer> findByIdAccomodation(String idAccomodation);
}
