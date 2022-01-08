package com.example.gestionpersonnelcpg.repositories;

import com.example.gestionpersonnelcpg.domain.Conges;
import com.example.gestionpersonnelcpg.domain.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CongesRepository extends JpaRepository<Conges, Long> {

    Optional<Conges> findTopByEmployeOrderByIdDesc(Employe employe);

    List<Conges> findAllByEmploye(Employe employe);

    long deleteCongesByEmploye_Id(long id);
}
