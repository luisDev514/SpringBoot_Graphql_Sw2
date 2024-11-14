package com.graphl.flight.controller;

import com.graphl.flight.models.Bed;
import com.graphl.flight.graphql.InputBed;
import com.graphl.flight.services.IBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class GraphQLBedController {

    @Autowired
    private IBedService bedService;

    @QueryMapping(name= "findBedById")
    public Bed findBedById(@Argument(name = "bedId") String id){
        String bedId = id;
        return bedService.findById(bedId);
    }


    @QueryMapping(name= "findAllBeds")
    public List<Bed> findAllBeds(){
        return bedService.findAllBeds();
    }

    @MutationMapping
    public Bed createBed(@Argument InputBed inputBed){
        Bed bed = new Bed();
        bed.setTitle(inputBed.getTitle());
        bed.setService(inputBed.getService());
        bedService.createBed(bed);
        return bed;
    }

    @MutationMapping()
    public String deleteBedById(@Argument(name = "bedId") String id){
        bedService.deleteById(id);
        return "Bed with id: " + id + " has been deleted";
    }

    @MutationMapping
    public Bed updateBed(@Argument(name = "bedId") String id, @Argument InputBed inputBed){
        Bed bed = new Bed();
        bed.setTitle(inputBed.getTitle());
        bed.setService(inputBed.getService());
        return bedService.updateBed(id, bed);
    }









}
