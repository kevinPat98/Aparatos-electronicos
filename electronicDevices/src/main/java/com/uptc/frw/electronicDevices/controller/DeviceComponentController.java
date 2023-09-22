package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.DeviceComponent;
import com.uptc.frw.electronicDevices.services.DeviceComponentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeviceComponentController {
    @Autowired
    private DeviceComponentServices componentServices;

    @QueryMapping
    public List<DeviceComponent> getDeviceComponents() {
        return componentServices.getAllDeviceComponents();
    }
    @QueryMapping
    public Optional<DeviceComponent> getDeviceComponent(@Argument("id") Long id) {
        return componentServices.getDeviceComponent(id);
    }
    @MutationMapping
    public DeviceComponent saveDeviceComponent(@Argument Long componentId, @Argument Long deviceId,@Argument int units) {
        return componentServices.saveDeviceComponent(componentId,deviceId,units);
    }
    @MutationMapping
    public DeviceComponent updateDeviceComponent(@Argument Long id, @Argument DeviceComponent deviceComponentRequest) {
        return componentServices.updateDeviceComponent(id, deviceComponentRequest);
    }
    @MutationMapping
    public void deleteDeviceComponent(@Argument Long id) {
        componentServices.deleteDeviceComponentServices(id);
    }
}
