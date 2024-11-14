package com.graphl.flight.repository;

import com.graphl.flight.models.OpinionForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOpinionFormDAO extends MongoRepository<OpinionForm, String> {
}
