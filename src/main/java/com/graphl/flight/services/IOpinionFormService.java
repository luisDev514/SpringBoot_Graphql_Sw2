package com.graphl.flight.services;

import com.graphl.flight.models.OpinionForm;

import java.util.List;

public interface IOpinionFormService {

    OpinionForm findById(String id);

    List<OpinionForm> findAllOpinionForms();

    void createOpinionForm(OpinionForm bed);

    void deleteById(String id);

    OpinionForm updateOpinionForm(String id, OpinionForm bed);

}
