package tn.esprit.gestionevenement.gestionevenement.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ressource {

    @Id
    private Integer id;
    private String clientname;
    private Integer phone;
    private String email;
}
