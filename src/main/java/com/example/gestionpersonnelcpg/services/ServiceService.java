package com.example.gestionpersonnelcpg.services;

import com.example.gestionpersonnelcpg.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    public ServiceRepository serviceRepository;

    public com.example.gestionpersonnelcpg.domain.Service update(com.example.gestionpersonnelcpg.domain.Service service) {
        return this.serviceRepository.save(service);

    }
}
