package tn.esprit.gestionevenement.gestionevenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionevenement.gestionevenement.entities.Fournisseur;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;

import java.io.Serializable;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
