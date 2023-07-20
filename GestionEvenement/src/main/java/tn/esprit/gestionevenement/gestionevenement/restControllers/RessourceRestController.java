package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Materiaux;
import tn.esprit.gestionevenement.gestionevenement.entities.Ressource;
import tn.esprit.gestionevenement.gestionevenement.services.IMateriaux;
import tn.esprit.gestionevenement.gestionevenement.services.IRessource;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class RessourceRestController {
    IRessource iRessource;
    @PostMapping("/addRessource")
    public Ressource addRessource(@RequestBody Ressource ressource){
        return iRessource.addRessource(ressource);
    }
    @PutMapping("/updateRessource/{id}")
    public ResponseEntity<Ressource> updateRessource (@PathVariable Integer id , @RequestBody Ressource ressource){
        return iRessource.updateRessource(id , ressource);
    }
    @GetMapping("/getRessourceById/{id}")
    public ResponseEntity<Ressource> retrieveRessourceById (@PathVariable("id") Integer id){
        return iRessource.retrieveRessourceById(id);
    }
    @GetMapping("/getAllRessource")
    public List<Ressource> retrieveAllRessource(){
        return iRessource.retrieveAllRessource();
    }

    @DeleteMapping("/deleteRessourceById/{id}")
    public ResponseEntity<HttpStatus> deleteRessourceById(@PathVariable ("id") Integer id){
        return iRessource.deleteRessourceById(id);
    }
}
