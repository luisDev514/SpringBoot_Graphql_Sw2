package com.graphl.flight.services;

import com.graphl.flight.models.Offer;

import java.util.List;

public interface IOfferService {

    Offer findById(String id);

    List<Offer> findAllOffers();

    void createOffer(Offer bed);

    void deleteById(String id);

    Offer updateOffer(String id, Offer bed);

    List<Offer> findOffersByAccomodationId(String idAccomodation);
}
