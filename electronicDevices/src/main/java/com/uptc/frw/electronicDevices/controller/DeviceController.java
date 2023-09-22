package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.Device;
import com.uptc.frw.electronicDevices.services.DeviceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DeviceController {
    @Autowired
    private DeviceServices deviceServices;

    @QueryMapping
    public List<Device> getDevices() {
        return deviceServices.getDevices();
    }
    @QueryMapping
    public Optional<Device> getDeviceById(@Argument("id") Long id) {
        return deviceServices.getDevice(id);
    }
    @MutationMapping
    public Device saveDevice(@Argument Long typeId,@Argument Device deviceRequest) {
        return deviceServices.saveDevice(typeId,deviceRequest);
    }
    @MutationMapping
    public Device updateDevice(@Argument Long id, @Argument Device deviceRequest) {
        return deviceServices.updateDevice(id, deviceRequest);
    }
    @MutationMapping
    public void deleteDevice(@Argument Long id) {
        deviceServices.deleteDevice(id);
    }
}
