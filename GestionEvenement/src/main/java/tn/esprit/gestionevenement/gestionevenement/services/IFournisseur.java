package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.gestionevenement.gestionevenement.entities.Fournisseur;

import java.util.List;

public interface IFournisseur {
    Fournisseur addFournisseur(Fournisseur fournisseur);
    ResponseEntity<Fournisseur> updateFournisseur (Integer id , Fournisseur fournisseur);
    ResponseEntity<Fournisseur> retrieveFournisseurById (Integer id);
    List<Fournisseur> retrieveAllFournisseur();
    ResponseEntity<HttpStatus> deleteFournisseurById(Integer id);

}
