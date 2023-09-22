package com.uptc.frw.electronicDevices.repository;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakerRepository extends JpaRepository<Maker,Long> {
}
