package com.uptc.frw.electronicDevices.repository;

import com.uptc.frw.electronicDevices.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
