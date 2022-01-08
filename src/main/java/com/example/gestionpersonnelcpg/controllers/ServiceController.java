package com.example.gestionpersonnelcpg.controllers;

import com.example.gestionpersonnelcpg.domain.Service;
import com.example.gestionpersonnelcpg.repositories.ServiceRepository;
import com.example.gestionpersonnelcpg.services.ServiceService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    private final ServiceService serviceService;

    public ServiceController(ServiceRepository serviceRepository, ServiceService serviceService) {
        this.serviceRepository = serviceRepository;
        this.serviceService = serviceService;
    }

    @PostMapping()
    public void create(@RequestBody Service service) {
        this.serviceRepository.save(service);
    }

    @GetMapping()
    public List<Service> retrieve() {
        return this.serviceRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Service> retrieveById(@PathVariable(value = "id") Long id) {
        return this.serviceRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Service> retrieveByName(@PathVariable(value = "name") String name) {
        return this.serviceRepository.findByName(name);
    }
    @PutMapping()
    public ResponseEntity<Service> update(@RequestBody Service service) {

        final Service updateService = this.serviceService.update(service);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
          this.serviceRepository.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        this.serviceRepository.deleteAll();
    }

}