package com.graphl.flight.repository;

import com.graphl.flight.models.Bed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBedDAO extends MongoRepository<Bed, String> {
}
