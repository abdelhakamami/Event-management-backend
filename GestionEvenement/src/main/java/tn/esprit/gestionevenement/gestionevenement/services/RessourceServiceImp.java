package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Ressource;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.RessourceRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class RessourceServiceImp implements IRessource{
    RessourceRepository ressourceRepository;
    @Override
    public Ressource addRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }
    @Override
    public ResponseEntity<Ressource> updateRessource(Integer id, Ressource ressource) {
        Ressource ressource1 = ressourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Materiaux not exist with id :" + id));
        ressource1.setClientname(ressource.getClientname());
        ressource1.setPhone(ressource.getPhone());
        ressource1.setEmail(ressource.getEmail());
        ressourceRepository.save(ressource1);
        return ResponseEntity.ok(ressource1);
    }

    @Override
    public ResponseEntity<Ressource> retrieveRessourceById(Integer id) {
        Ressource ressource1 = ressourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Materiaux not exist with id :" + id));
        return ResponseEntity.ok(ressource1);
    }

    @Override
    public List<Ressource> retrieveAllRessource() {
        return ressourceRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteRessourceById(Integer id) {
        Ressource ressource1 = ressourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("materiaux not exist with id :" + id));
        ressourceRepository.delete(ressource1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);    }
}
