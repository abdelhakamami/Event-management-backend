package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.gestionevenement.gestionevenement.entities.Fournisseur;
import tn.esprit.gestionevenement.gestionevenement.entities.Materiaux;

import java.util.List;

public interface IMateriaux {
        Materiaux addMateriaux(Materiaux materiaux);
        ResponseEntity<Materiaux> updateMateriaux (Integer id , Materiaux materiaux);
        ResponseEntity<Materiaux> retrieveMateriauxById (Integer id);
        List<Materiaux> retrieveAllMateriaux();
        ResponseEntity<HttpStatus> deleteMateriauxById(Integer id);

    }


