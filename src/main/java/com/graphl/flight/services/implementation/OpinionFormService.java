package com.graphl.flight.services.implementation;

import com.graphl.flight.models.OpinionForm;
import com.graphl.flight.repository.IOpinionFormDAO;
import com.graphl.flight.services.IOpinionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionFormService implements IOpinionFormService {

    @Autowired
    private IOpinionFormDAO opinionFormDAO;
    @Override
    public OpinionForm findById(String id) {
        return opinionFormDAO.findById(id).orElseThrow();
    }

    @Override
    public List<OpinionForm> findAllOpinionForms() {
        return (List<OpinionForm>) opinionFormDAO.findAll();
    }

    @Override
    public void createOpinionForm(OpinionForm opinionForm) {
        opinionFormDAO.save(opinionForm);

    }

    @Override
    public void deleteById(String id) {
        opinionFormDAO.deleteById(id);
    }

    @Override
    public OpinionForm updateOpinionForm(String id, OpinionForm opinionForm) {
        OpinionForm opinionFormToUpdate = opinionFormDAO.findById(id).orElseThrow();
        if (opinionForm.getState() != null) {
            opinionFormToUpdate.setState(opinionForm.getState());
        }
        if (opinionForm.getOrigin() != null) {
            opinionFormToUpdate.setOrigin(opinionForm.getOrigin());
        }
        if (opinionForm.getDestination() != null) {
            opinionFormToUpdate.setDestination(opinionForm.getDestination());
        }
        if (opinionForm.getTripOpinion() != null) {
            opinionFormToUpdate.setTripOpinion(opinionForm.getTripOpinion());
        }
        if (opinionForm.getDestinyOpinion() != null) {
            opinionFormToUpdate.setDestinyOpinion(opinionForm.getDestinyOpinion());
        }
        if (opinionForm.getAccommodationName() != null) {
            opinionFormToUpdate.setAccommodationName(opinionForm.getAccommodationName());
        }
        if (opinionForm.getReasonTrip() != null) {
            opinionFormToUpdate.setReasonTrip(opinionForm.getReasonTrip());
        }
        opinionFormDAO.save(opinionFormToUpdate);
        return opinionFormToUpdate;

    }
}
