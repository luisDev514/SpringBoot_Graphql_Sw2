package com.graphl.flight.services;

import com.graphl.flight.models.Bed;

import java.util.List;

public interface IBedService {

    Bed findById(String id);

    List<Bed> findAllBeds();

    void createBed(Bed bed);

    void deleteById(String id);

    Bed updateBed(String id, Bed bed);

}
