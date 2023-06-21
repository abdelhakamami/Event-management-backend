package tn.esprit.gestionevenement.gestionevenement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fistName;
    private String lastName;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    List<Reclamation> reclamations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonIgnore
    List<Feedback> feedbacks;
}
