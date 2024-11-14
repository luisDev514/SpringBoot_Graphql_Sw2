package com.graphl.flight.services.implementation;

import com.graphl.flight.models.Bed;
import com.graphl.flight.repository.IBedDAO;
import com.graphl.flight.services.IBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements IBedService {

    @Autowired
    private IBedDAO bedDAO;
    @Override
    public Bed findById(String id) {
        return bedDAO.findById(id).orElseThrow();
    }

    @Override
    public List<Bed> findAllBeds() {
        return (List<Bed>) bedDAO.findAll();
    }

    @Override
    public void createBed(Bed bed) {
        bedDAO.save(bed);

    }

    @Override
    public void deleteById(String id) {
        bedDAO.deleteById(id);
    }

    @Override
    public Bed updateBed(String id, Bed bed) {
        Bed bedToUpdate = bedDAO.findById(id).orElseThrow();
        bedToUpdate.setTitle(bed.getTitle());
        bedToUpdate.setService(bed.getService());
        bedDAO.save(bedToUpdate);
        return bedToUpdate;

    }


}
