package com.graphl.flight.controller;

import com.graphl.flight.models.Accomodation;
import com.graphl.flight.graphql.InputAccomodation;
import com.graphl.flight.services.IAccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class GraphQLAccomodationController {
    @Autowired
    private IAccomodationService accomodationService;

    @QueryMapping(name= "findAccomodationById")
    public Accomodation findAccomodationById(@Argument(name = "accomodationId") String id){
        String accomodationId = id;
        return accomodationService.findById(accomodationId);
    }



    @QueryMapping(name= "findAllAccomodations")
    public List<Accomodation> findAllAccomodations(){
        return accomodationService.findAllAccomodations();
    }



    @MutationMapping
    public Accomodation createAccomodation(@Argument InputAccomodation inputAccomodation){
        Accomodation accomodation = new Accomodation();
        accomodation.setDescription(inputAccomodation.getDescription());
        accomodation.setOwner(inputAccomodation.getOwner());
        accomodation.setSchedule(inputAccomodation.getSchedule());
        accomodation.setPage(inputAccomodation.getPage());
        accomodation.setQuantity(inputAccomodation.getQuantity());
        accomodation.setDescription_services(inputAccomodation.getDescription_services());
        accomodation.setAttention_number(inputAccomodation.getAttention_number());
        accomodation.setImageUrl(inputAccomodation.getImageUrl());
        accomodation.setTypeRoom(inputAccomodation.getTypeRoom());
        accomodation.setStars(inputAccomodation.getStars());
        accomodation.setInstagramUrl(inputAccomodation.getInstagramUrl());
        accomodation.setFacebookUrl(inputAccomodation.getFacebookUrl());
        accomodation.setWebUrl(inputAccomodation.getWebUrl());
        accomodation.setCompany(inputAccomodation.getCompany());
        accomodation.setCoordinates(inputAccomodation.getCoordinates());
        accomodation.setIdUser(inputAccomodation.getIdUser());





        accomodationService.createAccomodation(accomodation);
        return accomodation;
    }

    @MutationMapping()
    public String deleteAccomodationById(@Argument(name = "accomodationId") String id){
        accomodationService.deleteById(id);
        return "Accomodation with id: " + id + " has been deleted";
    }

    @MutationMapping
    public Accomodation updateAccomodation(@Argument(name = "accomodationId") String id, @Argument InputAccomodation inputAccomodation){
        Accomodation accomodation = new Accomodation();
        if (inputAccomodation.getDescription() != null) {
            accomodation.setDescription(inputAccomodation.getDescription());
        }
        if (inputAccomodation.getOwner() != null) {
            accomodation.setOwner(inputAccomodation.getOwner());
        }
        if (inputAccomodation.getSchedule() != null) {
            accomodation.setSchedule(inputAccomodation.getSchedule());
        }
        if (inputAccomodation.getPage() != null) {
            accomodation.setPage(inputAccomodation.getPage());
        }
        if (inputAccomodation.getQuantity() != null) {
            accomodation.setQuantity(inputAccomodation.getQuantity());
        }
        if (inputAccomodation.getDescription_services() != null) {
            accomodation.setDescription_services(inputAccomodation.getDescription_services());
        }
        if (inputAccomodation.getAttention_number() != null) {
            accomodation.setAttention_number(inputAccomodation.getAttention_number());
        }
        if (inputAccomodation.getImageUrl() != null) {
            accomodation.setImageUrl(inputAccomodation.getImageUrl());
        }
        if (inputAccomodation.getTypeRoom() != null) {
            accomodation.setTypeRoom(inputAccomodation.getTypeRoom());
        }
        if (inputAccomodation.getStars() != null) {
            accomodation.setStars(inputAccomodation.getStars());
        }
        if (inputAccomodation.getInstagramUrl() != null) {
            accomodation.setInstagramUrl(inputAccomodation.getInstagramUrl());
        }
        if (inputAccomodation.getFacebookUrl() != null) {
            accomodation.setFacebookUrl(inputAccomodation.getFacebookUrl());
        }
        if (inputAccomodation.getWebUrl() != null) {
            accomodation.setWebUrl(inputAccomodation.getWebUrl());
        }
        if (inputAccomodation.getCompany() != null) {
            accomodation.setCompany(inputAccomodation.getCompany());
        }
        if (inputAccomodation.getCoordinates() != null) {
            accomodation.setCoordinates(inputAccomodation.getCoordinates());
        }

        if (inputAccomodation.getIdUser() != null) {
            accomodation.setIdUser(inputAccomodation.getIdUser());
        }


        return accomodationService.updateAccomodation(id, accomodation);
    }

    @QueryMapping(name= "findAccomodationsByUserId")
    public List<Accomodation> findAccomodationsByUserId(@Argument(name = "userId") String userId){
        return accomodationService.findAccomodationsByUserId(userId);
    }

}
