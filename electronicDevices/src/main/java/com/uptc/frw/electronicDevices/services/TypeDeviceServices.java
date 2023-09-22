package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.entity.Device;
import com.uptc.frw.electronicDevices.entity.Repair;
import com.uptc.frw.electronicDevices.entity.TypeDevice;
import com.uptc.frw.electronicDevices.repository.RepairRepository;
import com.uptc.frw.electronicDevices.repository.TypeDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TypeDeviceServices {
    @Autowired
    TypeDeviceRepository typeDeviceRepository;
    public List<TypeDevice> getTypeDevices(){
        return typeDeviceRepository.findAll();
    }

    public Optional<TypeDevice> getTypeDevice(Long id){
        return Optional.ofNullable(typeDeviceRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Tipo %s no encontrado", id))
        ));
    }
    public TypeDevice saveTypeDevice(Long superTypeId, TypeDevice typeDeviceRequest) {
            TypeDevice typeDevice = new TypeDevice();
            typeDevice.setName(typeDeviceRequest.getName());
            typeDevice.setCharacteristic(typeDeviceRequest.getCharacteristic());

            if (superTypeId != null) {
                Optional<TypeDevice> superTypeDeviceOptional = typeDeviceRepository.findById(superTypeId);
                if (superTypeDeviceOptional.isPresent()) {
                    TypeDevice superTypeDevice = superTypeDeviceOptional.get();
                    typeDevice.setTypeDevice(superTypeDevice);
                } else {
                    throw new RuntimeException("No se pudo encontrar el supertipo");
                }
            }

            return typeDeviceRepository.save(typeDevice);
    }

    public void deleteTypeDevice(long id){
        Optional<TypeDevice> typeDeviceOptional = typeDeviceRepository.findById(id);
        if (typeDeviceOptional.isPresent()) {
            typeDeviceRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Tipo %s no encontrado", id));
        }
    }

    public TypeDevice updateTypeDevice(Long id, TypeDevice typeDeviceRequest) {
        Optional<TypeDevice> typeDeviceOptional = typeDeviceRepository.findById(id);
        if (typeDeviceOptional.isPresent()) {
            TypeDevice existingTypeDevice = typeDeviceOptional.get();
            if (typeDeviceRequest.getName()!= null) {
                existingTypeDevice.setName(typeDeviceRequest.getName());
            }
            if (typeDeviceRequest.getCharacteristic() != null) {
                existingTypeDevice.setCharacteristic(typeDeviceRequest.getCharacteristic());
            }
            return typeDeviceRepository.save(existingTypeDevice);
        } else {
            throw new RuntimeException(String.format("Tipo %s no encontrado", id));
        }
    }
}
