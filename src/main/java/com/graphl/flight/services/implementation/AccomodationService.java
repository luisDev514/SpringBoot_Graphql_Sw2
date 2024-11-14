package com.graphl.flight.services.implementation;

import com.graphl.flight.models.Accomodation;
import com.graphl.flight.repository.IAccomodationDAO;
import com.graphl.flight.repository.IUserDAO;
import com.graphl.flight.services.IAccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationService implements IAccomodationService {

    @Autowired
    private IAccomodationDAO accomodationDAO;
    private IUserDAO    userDAO;
    @Override
    public Accomodation findById(String id) {
        return accomodationDAO.findById(id).orElseThrow();
    }

    @Override
    public List<Accomodation> findAllAccomodations() {
        return (List<Accomodation>) accomodationDAO.findAll();
    }

    @Override
    public void createAccomodation(Accomodation accomodation) {
        accomodationDAO.save(accomodation);

    }

    @Override
    public void deleteById(String id) {
        accomodationDAO.deleteById(id);
    }



    @Override
    public Accomodation updateAccomodation(String id, Accomodation accomodation) {
        Accomodation accomodationToUpdate = accomodationDAO.findById(id).orElseThrow();
        if (accomodation.getAttention_number() != null) {
            accomodationToUpdate.setAttention_number(accomodation.getAttention_number());
        }
        if (accomodation.getOwner() != null) {
            accomodationToUpdate.setOwner(accomodation.getOwner());
        }
        if (accomodation.getDescription() != null) {
            accomodationToUpdate.setDescription(accomodation.getDescription());
        }
        if (accomodation.getSchedule() != null) {
            accomodationToUpdate.setSchedule(accomodation.getSchedule());
        }
        if (accomodation.getPage() != null) {
            accomodationToUpdate.setPage(accomodation.getPage());
        }
        if (accomodation.getQuantity() != null) {
            accomodationToUpdate.setQuantity(accomodation.getQuantity());
        }
        if (accomodation.getDescription_services() != null) {
            accomodationToUpdate.setDescription_services(accomodation.getDescription_services());
        }
        if (accomodation.getImageUrl() != null) {
            accomodationToUpdate.setImageUrl(accomodation.getImageUrl());
        }
        if (accomodation.getTypeRoom() != null) {
            accomodationToUpdate.setTypeRoom(accomodation.getTypeRoom());
        }
        if (accomodation.getFacebookUrl() != null) {
            accomodationToUpdate.setFacebookUrl(accomodation.getFacebookUrl());
        }
        if (accomodation.getInstagramUrl() != null) {
            accomodationToUpdate.setInstagramUrl(accomodation.getInstagramUrl());
        }
        if (accomodation.getWebUrl() != null) {
            accomodationToUpdate.setWebUrl(accomodation.getWebUrl());
        }
        if (accomodation.getStars() != null) {
            accomodationToUpdate.setStars(accomodation.getStars());
        }
        if (accomodation.getCompany() != null) {
            accomodationToUpdate.setCompany(accomodation.getCompany());
        }
        if (accomodation.getCoordinates() != null) {
            accomodationToUpdate.setCoordinates(accomodation.getCoordinates());
        }

        if (accomodation.getIdUser() != null) {
            accomodationToUpdate.setIdUser(accomodation.getIdUser());
        }

        accomodationDAO.save(accomodationToUpdate);
        return accomodationToUpdate;

    }

    @Override
    public List<Accomodation> findAccomodationsByUserId(String idUser) {
        List<Accomodation> accomodations = accomodationDAO.findByIdUser(idUser);
        if (accomodations.isEmpty()) {
            throw new RuntimeException("No accomodations found for user with id: " + idUser);

        }
        return accomodations;
    }


}
