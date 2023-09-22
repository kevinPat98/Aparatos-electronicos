package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.Maker;
import com.uptc.frw.electronicDevices.services.MakerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MakerController {
    @Autowired
    private MakerServices makerServices;

    @QueryMapping
    public List<Maker> getMakers() {
        return makerServices.getMakers();
    }
    @QueryMapping
    public Optional<Maker> getMakerById(@Argument("id") Long id) {
        return makerServices.getMaker(id);
    }
    @MutationMapping
    public Maker saveMaker(@Argument Maker makerRequest) {
        return makerServices.saveMaker(makerRequest);
    }
    @MutationMapping
    public Maker updateMaker(@Argument Long id, @Argument Maker makerRequest) {
        return makerServices.updateMaker(id, makerRequest);
    }
    @MutationMapping
    public void deleteMaker(@Argument Long id) {
        makerServices.deleteMaker(id);
    }
}
