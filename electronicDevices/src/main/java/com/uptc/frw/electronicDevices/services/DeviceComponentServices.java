package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Component;
import com.uptc.frw.electronicDevices.entity.Device;
import com.uptc.frw.electronicDevices.entity.DeviceComponent;
import com.uptc.frw.electronicDevices.entity.Maker;
import com.uptc.frw.electronicDevices.entity.key.DeviceComponentPk;
import com.uptc.frw.electronicDevices.repository.ComponentRepository;
import com.uptc.frw.electronicDevices.repository.DeviceComponentRepository;
import com.uptc.frw.electronicDevices.repository.DeviceRepository;
import com.uptc.frw.electronicDevices.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceComponentServices {
    @Autowired
    DeviceComponentRepository deviceComponentRepository;
    @Autowired
    ComponentRepository componentRepository;
    @Autowired
    DeviceRepository deviceRepository;
    public List<DeviceComponent> getAllDeviceComponents() {
        return deviceComponentRepository.findAll();
    }

    public Optional<DeviceComponent> getDeviceComponent(Long id) {
        return deviceComponentRepository.findById(id);
    }
    public DeviceComponent saveDeviceComponent(Long componentId, Long deviceId, int units) {
        Optional<Component> componentOptional = componentRepository.findById(componentId);
        if (componentOptional.isEmpty()) {
            throw new RuntimeException("No se pudo encontrar el Componente");
        }
        Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
        if (deviceOptional.isEmpty()) {
            throw new RuntimeException("No se pudo encontrar el Aparato");
        }
        DeviceComponent deviceComponent = new DeviceComponent();
        deviceComponent.setComponent(componentOptional.get());
        deviceComponent.setDevices(deviceOptional.get());
        deviceComponent.setUnits(units);
        return deviceComponentRepository.save(deviceComponent);
    }

    public void deleteDeviceComponentServices(long id){
        Optional<DeviceComponent> optionalDeviceComponent = deviceComponentRepository.findById(id);
        if (optionalDeviceComponent.isPresent()) {
            deviceComponentRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Registro Unidades %s no encontrado", id));
        }
    }

    public DeviceComponent updateDeviceComponent(Long id, DeviceComponent deviceComponentRequest) {
        Optional<DeviceComponent> deviceComponentOptional = deviceComponentRepository.findById(id);
        if (deviceComponentOptional.isPresent()) {
            DeviceComponent existingDeviceComponent = deviceComponentOptional.get();
            if (deviceComponentRequest.getUnits() != null) {
                existingDeviceComponent.setUnits(deviceComponentRequest.getUnits());
            }
            return deviceComponentRepository.save(existingDeviceComponent);
        } else {
            throw new RuntimeException(String.format("Registro unidades %s no encontrada", id));
        }
    }
}
