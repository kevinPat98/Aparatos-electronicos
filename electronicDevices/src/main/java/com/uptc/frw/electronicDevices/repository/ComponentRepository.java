package com.uptc.frw.electronicDevices.repository;

import com.uptc.frw.electronicDevices.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component,Long> {
}
