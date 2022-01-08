package com.example.gestionpersonnelcpg.domain;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Employe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nomEmp;
    private String prenomEmp;
    private Date dateNaissance;
    private Date dateEmbauche;

}
