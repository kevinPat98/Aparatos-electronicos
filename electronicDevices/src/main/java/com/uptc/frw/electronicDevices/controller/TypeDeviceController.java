package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.TypeDevice;
import com.uptc.frw.electronicDevices.services.TypeDeviceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class TypeDeviceController {
    @Autowired
    private TypeDeviceServices typeDeviceServices;

    @QueryMapping
    public List<TypeDevice> getTypeDeviceServices() {
        return typeDeviceServices.getTypeDevices();
    }
    @QueryMapping
    public Optional<TypeDevice> getTypeDeviceService(@Argument("id") Long id) {
        return typeDeviceServices.getTypeDevice(id);
    }
    @MutationMapping
    public TypeDevice saveTypeDevice(@Argument Long superTypeId,@Argument TypeDevice typeDeviceRequest){
        return typeDeviceServices.saveTypeDevice(superTypeId,typeDeviceRequest);
    }
    @MutationMapping
    public TypeDevice updateTypeDevice(@Argument Long id, @Argument TypeDevice typeDeviceRequest) {
        return typeDeviceServices.updateTypeDevice(id, typeDeviceRequest);
    }
    @MutationMapping
    public void deleteTypeDevice(@Argument Long id) {
        typeDeviceServices.deleteTypeDevice(id);
    }
}
