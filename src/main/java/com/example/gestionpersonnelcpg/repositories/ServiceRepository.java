package com.example.gestionpersonnelcpg.repositories;

import com.example.gestionpersonnelcpg.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Optional<Service> findByName(String name);
}
