package tn.esprit.gestionevenement.gestionevenement.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Reclamation implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    @ManyToOne
    User user;
}
