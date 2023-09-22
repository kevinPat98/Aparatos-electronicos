package com.uptc.frw.electronicDevices.repository;

import com.uptc.frw.electronicDevices.entity.DeviceComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceComponentRepository extends JpaRepository<DeviceComponent,Long> {
}
