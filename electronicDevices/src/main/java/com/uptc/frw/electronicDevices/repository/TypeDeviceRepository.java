package com.uptc.frw.electronicDevices.repository;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.entity.TypeDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDeviceRepository extends JpaRepository<TypeDevice,Long> {
}
