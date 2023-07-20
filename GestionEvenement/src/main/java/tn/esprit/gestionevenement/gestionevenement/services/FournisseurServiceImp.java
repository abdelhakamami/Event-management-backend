package tn.esprit.gestionevenement.gestionevenement.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Fournisseur;
import tn.esprit.gestionevenement.gestionevenement.entities.Logistique;
import tn.esprit.gestionevenement.gestionevenement.exceptions.ResourceNotFoundException;
import tn.esprit.gestionevenement.gestionevenement.repositories.FournisseurRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class FournisseurServiceImp implements IFournisseur{
    FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public ResponseEntity<Fournisseur> updateFournisseur(Integer id, Fournisseur fournisseur) {
        Fournisseur fournisseur1 = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fournisseur does not exist with id: " + id));
        fournisseur1.setName(fournisseur.getName());
        fournisseur1.setContact(fournisseur.getContact());
        fournisseurRepository.save(fournisseur1);
        return ResponseEntity.ok(fournisseur1);
    }
    @Override
    public ResponseEntity<Fournisseur> retrieveFournisseurById(Integer id) {
        Fournisseur fournisseur1 = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fournisseur not exist with id :" + id));
        return ResponseEntity.ok(fournisseur1);
    }

    @Override
    public List<Fournisseur> retrieveAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> deleteFournisseurById(Integer id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fournisseur not exist with id :" + id));
        fournisseurRepository.delete(fournisseur);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
