package com.example.gestionpersonnelcpg.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Conges {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer nbrTotal;
    private Date dateDebut;
    private Date dateFin;
    private Integer reste;

    @ManyToOne
    private Employe employe ;

}
