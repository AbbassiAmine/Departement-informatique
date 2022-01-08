package com.example.gestionpersonnelcpg.controllers;

import com.example.gestionpersonnelcpg.domain.Conges;
import com.example.gestionpersonnelcpg.domain.Employe;
import com.example.gestionpersonnelcpg.repositories.CongesRepository;
import com.example.gestionpersonnelcpg.repositories.EmployeRepository;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/conges")
public class CongesController {

    private final CongesRepository congesRepository;

    private final EmployeRepository employeRepository;

    public CongesController(CongesRepository congesRepository, EmployeRepository employeRepository) {
        this.congesRepository = congesRepository;
        this.employeRepository = employeRepository;
    }

    @PostMapping()
    public void create(@RequestBody Conges conges ) {

        Optional<Conges> congesOfEmploye = this.congesRepository.findTopByEmployeOrderByIdDesc(conges.getEmploye());

        // Get the duration between the dateDebut and the dateFin to retrieve how many days he toke
        int nbrOfDayCongeTaked = (int) (((conges.getDateFin().getTime() - conges.getDateDebut().getTime())/ (1000*60*60*24)) +1);

        // We test if we dont have a reste so its the first conge taken -> we touch the total value
        // Otherwise we touche the reste value
        // set the reste conge value before saving the hole Conges

        if(congesOfEmploye.isEmpty()){
             conges.setReste(conges.getNbrTotal() - nbrOfDayCongeTaked);
            this.congesRepository.save(conges);
        }else{
            if(congesOfEmploye.get().getReste() != 0 && nbrOfDayCongeTaked <= congesOfEmploye.get().getReste()){
                conges.setReste(congesOfEmploye.get().getReste() - nbrOfDayCongeTaked);
                this.congesRepository.save(conges);
            }
        }

    }

    @GetMapping()
    public List<Conges> retrieve() {
        return this.congesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Conges> retrieveById(@PathVariable(value = "id") Long id) {
        return this.congesRepository.findById(id);
    }

    @GetMapping("/latest/{id}")
    public Optional<Conges> retrieveLatesConges(@PathVariable(value = "id") Long id) {
        Optional<Employe> employe = this.employeRepository.findById(id);
        return this.congesRepository.findTopByEmployeOrderByIdDesc(employe.get());
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        this.congesRepository.deleteById(id);
    }

    @DeleteMapping("/delete/employe/{id}")
    @Transactional
    public long deleteByEmploye(@PathVariable(value = "id") Long id) {
        return this.congesRepository.deleteCongesByEmploye_Id(id);
    }

}