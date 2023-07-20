package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Fournisseur;
import tn.esprit.gestionevenement.gestionevenement.services.IFournisseur;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@AllArgsConstructor
public class FournisseurRestController {
    IFournisseur iFournisseur;
    @PostMapping("/addFournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
        return iFournisseur.addFournisseur(fournisseur);
    }
    @PutMapping("/updateFournisseur/{id}")
    public ResponseEntity<Fournisseur> updateMateriaux (@PathVariable Integer id , @RequestBody Fournisseur fournisseur){
        return iFournisseur.updateFournisseur(id ,fournisseur);
    }
    @GetMapping("/getFournisseurById/{id}")
    public ResponseEntity<Fournisseur> retrieveFournisseurById (@PathVariable("id") Integer id){
        return iFournisseur.retrieveFournisseurById(id);
    }
    @GetMapping("/getAllFournisseur")
    public List<Fournisseur> retrieveAllFournisseur(){
        return iFournisseur.retrieveAllFournisseur();
    }

    @DeleteMapping("/deleteFournisseurById/{id}")
    public ResponseEntity<HttpStatus> deleteFournisseurById(@PathVariable ("id") Integer id){
        return iFournisseur.deleteFournisseurById(id);
    }
}
