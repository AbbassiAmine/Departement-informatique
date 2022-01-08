package com.example.gestionpersonnelcpg.controllers;

import com.example.gestionpersonnelcpg.domain.Employe;
import com.example.gestionpersonnelcpg.domain.Service;
import com.example.gestionpersonnelcpg.repositories.EmployeRepository;
import com.example.gestionpersonnelcpg.repositories.ServiceRepository;
import com.example.gestionpersonnelcpg.services.ServiceService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/employe")
public class EmployeController {

    private final EmployeRepository employeRepository;

    public EmployeController(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @PostMapping()
    public void create(@RequestBody Employe employe) {
        this.employeRepository.save(employe);
    }

    @GetMapping()
    public List<Employe> retrieve() {
        return this.employeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employe> retrieveById(@PathVariable(value = "id") Long id) {
        return this.employeRepository.findById(id);
    }

    @GetMapping("/name/{nomEmp}")
    public List<Employe> retrieveByName(@PathVariable(value = "nomEmp") String nomEmp) {

        return this.employeRepository.findByNomEmp(nomEmp);
    }

    @PutMapping()
    public ResponseEntity<Employe> update(@RequestBody Employe employe) {

        final Employe updateService = this.employeRepository.save(employe);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {

          this.employeRepository.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        this.employeRepository.deleteAll();
    }

}