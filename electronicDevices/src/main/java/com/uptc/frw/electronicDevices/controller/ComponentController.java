package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.Component;
import com.uptc.frw.electronicDevices.services.ComponentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ComponentController {
    @Autowired
    private ComponentServices componentServices;

    @QueryMapping
    public List<Component> getComponents() {
        return componentServices.getComponents();
    }
    @QueryMapping
    public Optional<Component> getComponent(@Argument("id") Long id) {
        return componentServices.getComponent(id);
    }
    @MutationMapping
    public Component saveComponent(@Argument Long makerId,@Argument Component componentRequest){
        return componentServices.saveComponent(makerId,componentRequest);
    }
    @MutationMapping
    public Component updateComponent(@Argument Long id, @Argument Component componentRequest) {
        return componentServices.updateComponent(id, componentRequest);
    }
    @MutationMapping
    public void deleteComponent(@Argument Long id) {
        componentServices.deleteComponent(id);
    }
}
