package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.gestionevenement.gestionevenement.entities.Materiaux;
import tn.esprit.gestionevenement.gestionevenement.entities.Ressource;

import java.util.List;

public interface IRessource {
    Ressource addRessource(Ressource ressource);
    ResponseEntity<Ressource> updateRessource (Integer id , Ressource ressource);
    ResponseEntity<Ressource> retrieveRessourceById (Integer id);
    List<Ressource> retrieveAllRessource();
    ResponseEntity<HttpStatus> deleteRessourceById(Integer id);

}
