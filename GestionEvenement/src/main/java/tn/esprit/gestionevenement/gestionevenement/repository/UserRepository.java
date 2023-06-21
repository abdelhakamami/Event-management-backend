package tn.esprit.gestionevenement.gestionevenement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionevenement.gestionevenement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
