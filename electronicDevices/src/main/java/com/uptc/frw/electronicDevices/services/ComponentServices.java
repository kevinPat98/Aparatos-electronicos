package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.entity.Component;
import com.uptc.frw.electronicDevices.entity.Maker;
import com.uptc.frw.electronicDevices.repository.ClientRepository;
import com.uptc.frw.electronicDevices.repository.ComponentRepository;
import com.uptc.frw.electronicDevices.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComponentServices {
    @Autowired
    MakerRepository makerRepository;
    @Autowired
    ComponentRepository componentRepository;


    public List<Component> getComponents(){
        return componentRepository.findAll();
    }

    public Optional<Component> getComponent(Long id){
        return Optional.ofNullable(componentRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Reparacion %s no encontrado", id))
        ));
    }
    public Component saveComponent(long makerId, Component componentRequest) {
        Optional<Maker> makerOptional = makerRepository.findById(makerId);
        if (makerOptional.isEmpty()) {
            throw new RuntimeException("No se pudo encontrar el Fabricante");
        }
        Maker maker = makerOptional.get();
        Component component = new Component();
        component.setName(componentRequest.getName());
        component.setSpecifications(componentRequest.getSpecifications());
        component.setMakers(maker);
        return componentRepository.save(component);
    }

    public void deleteComponent(long id){
        Optional<Component> optionalComponent = componentRepository.findById(id);
        if (optionalComponent.isPresent()) {
            componentRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Componente %s no encontrado", id));
        }
    }

    public Component updateComponent(Long id, Component componentRequest) {
        Optional<Component> componentOptional = componentRepository.findById(id);
        if (componentOptional.isPresent()) {
            Component existingComponent = componentOptional.get();
            if (componentRequest.getName() != null) {
                existingComponent.setName(componentRequest.getName());
            }
            if (componentRequest.getSpecifications() != null) {
                existingComponent.setSpecifications(componentRequest.getSpecifications());
            }
            return componentRepository.save(existingComponent);
        } else {
            throw new RuntimeException(String.format("Reparación %s no encontrada", id));
        }
    }
}
