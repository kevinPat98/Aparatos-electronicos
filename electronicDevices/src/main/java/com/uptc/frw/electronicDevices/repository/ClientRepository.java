package com.uptc.frw.electronicDevices.repository;

import com.uptc.frw.electronicDevices.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
