package com.graphl.flight.controller;

import com.graphl.flight.models.OpinionForm;
import com.graphl.flight.models.OpinionForm;
import com.graphl.flight.graphql.InputOpinionForm;
import com.graphl.flight.models.User;
import com.graphl.flight.services.IOpinionFormService;
import com.graphl.flight.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
public class GraphQLOpinionFormController {

    @Autowired
    private IOpinionFormService opinionFormService;
    @Autowired
    private IUserService userService;

    @QueryMapping(name= "findOpinionFormById")
    public OpinionForm findOpinionFormById(@Argument(name = "opinionFormId") String id){
        String opinionFormId = id;
        return opinionFormService.findById(opinionFormId);
    }


    @QueryMapping(name= "findAllOpinionForms")
    public List<OpinionForm> findAllOpinionForms(){
        return opinionFormService.findAllOpinionForms();
    }

    @MutationMapping
    public OpinionForm createOpinionForm(@Argument InputOpinionForm inputOpinionForm){
        OpinionForm opinionForm = new OpinionForm();
        opinionForm.setState(inputOpinionForm.getState());
        opinionForm.setOrigin(inputOpinionForm.getOrigin());
        opinionForm.setDestination(inputOpinionForm.getDestination());
        opinionForm.setTripOpinion(inputOpinionForm.getTripOpinion());
        opinionForm.setDestinyOpinion(inputOpinionForm.getDestinyOpinion());
        opinionForm.setAccommodationName(inputOpinionForm.getAccommodationName());
        opinionForm.setReasonTrip(inputOpinionForm.getReasonTrip());
        opinionForm.setIdUser(inputOpinionForm.getIdUser());


        User user = userService.findById(opinionForm.getIdUser());
        System.out.println(user);
        if (user != null) {
            opinionForm.setUser(user);
        } else {
            // Manejar el caso en que no se encuentra el OpinionForm
            throw new RuntimeException("IdUser not found with id: " + opinionForm.getIdUser());
        }
        
        

        opinionFormService.createOpinionForm(opinionForm);
        return opinionForm;
    }

    @MutationMapping()
    public String deleteOpinionFormById(@Argument(name = "opinionFormId") String id){
        opinionFormService.deleteById(id);
        return "OpinionForm with id: " + id + " has been deleted";
    }

    @MutationMapping
    public OpinionForm updateOpinionForm(@Argument(name = "opinionFormId") String id, @Argument InputOpinionForm inputOpinionForm){
        OpinionForm opinionForm = new OpinionForm();
        if (inputOpinionForm.getState() != null) {
            opinionForm.setState(inputOpinionForm.getState());
        }
        if (inputOpinionForm.getOrigin() != null) {
            opinionForm.setOrigin(inputOpinionForm.getOrigin());
        }
        if (inputOpinionForm.getDestination() != null) {
            opinionForm.setDestination(inputOpinionForm.getDestination());
        }
        if (inputOpinionForm.getTripOpinion() != null) {
            opinionForm.setTripOpinion(inputOpinionForm.getTripOpinion());
        }
        if (inputOpinionForm.getDestinyOpinion() != null) {
            opinionForm.setDestinyOpinion(inputOpinionForm.getDestinyOpinion());
        }
        if (inputOpinionForm.getAccommodationName() != null) {
            opinionForm.setAccommodationName(inputOpinionForm.getAccommodationName());
        }
        if (inputOpinionForm.getReasonTrip() != null) {
            opinionForm.setReasonTrip(inputOpinionForm.getReasonTrip());
        }



        
        return opinionFormService.updateOpinionForm(id, opinionForm);
    }
}
