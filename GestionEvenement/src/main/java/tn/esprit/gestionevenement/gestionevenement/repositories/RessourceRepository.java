package tn.esprit.gestionevenement.gestionevenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionevenement.gestionevenement.entities.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource, Integer> {
}
