package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Component;
import com.uptc.frw.electronicDevices.entity.Device;
import com.uptc.frw.electronicDevices.entity.Maker;
import com.uptc.frw.electronicDevices.entity.TypeDevice;
import com.uptc.frw.electronicDevices.repository.DeviceRepository;
import com.uptc.frw.electronicDevices.repository.TypeDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServices {
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    TypeDeviceRepository typeDeviceRepository;


    public List<Device> getDevices(){
        return deviceRepository.findAll();
    }

    public Optional<Device> getDevice(Long id){
        return Optional.ofNullable(deviceRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Aparato %s no encontrado", id))
        ));
    }
    public Device saveDevice(long typeId, Device deviceRequest) {
        Optional<TypeDevice> typeDevice = typeDeviceRepository.findById(typeId);
        if (typeDevice.isEmpty()) {
            throw new RuntimeException("No se pudo encontrar el Tipo");
        }
        TypeDevice typeDevice1 = typeDevice.get();
        Device device = new Device();
        device.setCode(deviceRequest.getCode());
        device.setName(deviceRequest.getName());
        device.setDecription(deviceRequest.getDecription());
        device.setDevice(typeDevice1);
        return deviceRepository.save(device);
    }

    public void deleteDevice(long id){
        Optional<Device> optionalComponent = deviceRepository.findById(id);
        if (optionalComponent.isPresent()) {
            deviceRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Aparato %s no encontrado", id));
        }
    }

    public Device updateDevice(Long id, Device deviceRequest) {
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if (deviceOptional.isPresent()) {
            Device existingDevice = deviceOptional.get();
            if (deviceRequest.getCode() != null) {
                existingDevice.setCode(deviceRequest.getCode());
            }
            if (deviceRequest.getName()!= null) {
                existingDevice.setName(deviceRequest.getName());
            }
            if (deviceRequest.getDecription() != null) {
                existingDevice.setDecription(deviceRequest.getDecription());
            }
            return deviceRepository.save(existingDevice);
        } else {
            throw new RuntimeException(String.format("Reparación %s no encontrada", id));
        }
    }
}
