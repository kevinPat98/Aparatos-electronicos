package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Device;
import com.uptc.frw.electronicDevices.entity.Maker;
import com.uptc.frw.electronicDevices.entity.TypeDevice;
import com.uptc.frw.electronicDevices.repository.DeviceRepository;
import com.uptc.frw.electronicDevices.repository.MakerRepository;
import com.uptc.frw.electronicDevices.repository.TypeDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServices {
    @Autowired
    MakerRepository makerRepository;

    public List<Maker> getMakers(){
        return makerRepository.findAll();
    }

    public Optional<Maker> getMaker(Long id){
        return Optional.ofNullable(makerRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Fabricante %s no encontrado", id))
        ));
    }
    public Maker saveMaker(Maker makerRequest) {;
        Maker maker = new Maker();
        maker.setRif(makerRequest.getRif());
        maker.setName(makerRequest.getName());
        maker.setAddress(makerRequest.getAddress());
        return makerRepository.save(maker);
    }

    public void deleteMaker(long id){
        Optional<Maker> optionalMaker = makerRepository.findById(id);
        if (optionalMaker.isPresent()) {
            makerRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Fabricante %s no encontrado", id));
        }
    }

    public Maker updateMaker(Long id, Maker makerRequest) {
        Optional<Maker> makerOptional = makerRepository.findById(id);
        if (makerOptional.isPresent()) {
            Maker existingMaker = makerOptional.get();
            if (makerRequest.getRif() != null) {
                existingMaker.setRif(makerRequest.getRif());
            }
            if (makerRequest.getName()!= null) {
                existingMaker.setName(makerRequest.getName());
            }
            if (makerRequest.getAddress() != null) {
                existingMaker.setAddress(makerRequest.getAddress());
            }
            return makerRepository.save(existingMaker);
        } else {
            throw new RuntimeException(String.format("Fabricante %s no encontrado", id));
        }
    }
}
