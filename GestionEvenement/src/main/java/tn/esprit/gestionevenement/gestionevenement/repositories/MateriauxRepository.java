package tn.esprit.gestionevenement.gestionevenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionevenement.gestionevenement.entities.Materiaux;

public interface MateriauxRepository extends JpaRepository <Materiaux, Integer> {
}
