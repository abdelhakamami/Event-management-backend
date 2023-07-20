package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;
import tn.esprit.gestionevenement.gestionevenement.entities.Materiaux;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.LogistiqueRepository;
import tn.esprit.gestionevenement.gestionevenement.repositories.MateriauxRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class MateriauxServiceImp implements IMateriaux{
    MateriauxRepository materiauxRepository;
    @Override
    public Materiaux addMateriaux(Materiaux materiaux) {
        return materiauxRepository.save(materiaux);
    }

    @Override
    public ResponseEntity<Materiaux> updateMateriaux(Integer id, Materiaux materiaux) {
        Materiaux materiaux1 = materiauxRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Materiaux not exist with id :" + id));
        materiaux1.setName(materiaux.getName());
        materiaux1.setQuantite(materiaux.getQuantite());
        materiauxRepository.save(materiaux1);

        return ResponseEntity.ok(materiaux1);
    }

    @Override
    public ResponseEntity<Materiaux> retrieveMateriauxById(Integer id) {
        Materiaux materiaux2 = materiauxRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Materiaux not exist with id :" + id));

        return ResponseEntity.ok(materiaux2);
    }

    @Override
    public List<Materiaux> retrieveAllMateriaux() {
        return materiauxRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteMateriauxById(Integer id) {
        Materiaux materiaux3 = materiauxRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("materiaux not exist with id :" + id));
        materiauxRepository.delete(materiaux3);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
