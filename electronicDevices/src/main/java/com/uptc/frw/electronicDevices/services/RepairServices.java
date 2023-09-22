package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.entity.Device;
import com.uptc.frw.electronicDevices.entity.Repair;
import com.uptc.frw.electronicDevices.repository.ClientRepository;
import com.uptc.frw.electronicDevices.repository.DeviceRepository;
import com.uptc.frw.electronicDevices.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class RepairServices {
    @Autowired
    RepairRepository repairRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DeviceRepository deviceRepository;

    public List<Repair> getRepairts(){
        return repairRepository.findAll();
    }

    public Optional<Repair> getRepairt(Long id){
        return Optional.ofNullable(repairRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Reparacion %s no encontrado", id))
        ));
    }
    public Repair saveReparation(long customerId, long deviceId, Repair repairRequest) {
        Optional<Client> clientOptional = clientRepository.findById(customerId);
        Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
        if (clientOptional.isEmpty() || deviceOptional.isEmpty()) {
            throw new RuntimeException("No se pudo encontrar el cliente o aparato.");
        }
        Client client = clientOptional.get();
        Device device = deviceOptional.get();
        Repair reparation = new Repair();
        reparation.setRefence(repairRequest.getRefence());
        reparation.setDescription(repairRequest.getDescription());
        reparation.setDateRepair(new Date());
        reparation.setClient(client);
        reparation.setDevice(device);
        return repairRepository.save(reparation);
    }

    public void deleteRepair(long id){
        Optional<Repair> optionalReparation = repairRepository.findById(id);
        if (optionalReparation.isPresent()) {
            repairRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Reparacion %s no encontrado", id));
        }
    }

    public Repair updateReparation(Long id, Repair reparationRequest) {
        Optional<Repair> reparationOptional = repairRepository.findById(id);
        if (reparationOptional.isPresent()) {
            Repair existingReparation = reparationOptional.get();
            if (reparationRequest.getRefence()!= null) {
                existingReparation.setRefence(reparationRequest.getRefence());
            }
            if (reparationRequest.getDescription() != null) {
                existingReparation.setDescription(reparationRequest.getDescription());
            }
            return repairRepository.save(existingReparation);
        } else {
            throw new RuntimeException(String.format("Reparación %s no encontrada", id));
        }
    }
}
