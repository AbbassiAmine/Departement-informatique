package com.example.gestionpersonnelcpg.repositories;

import com.example.gestionpersonnelcpg.domain.Employe;
import com.example.gestionpersonnelcpg.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findByNomEmp(String nomEmp);
}
