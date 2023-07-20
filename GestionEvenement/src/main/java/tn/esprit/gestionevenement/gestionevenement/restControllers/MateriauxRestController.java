package tn.esprit.gestionevenement.gestionevenement.restControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Materiaux;
import tn.esprit.gestionevenement.gestionevenement.services.IMateriaux;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class MateriauxRestController {
    IMateriaux iMateriaux;
    @PostMapping("/addMateriaux")
    public Materiaux addMateriaux(@RequestBody Materiaux materiaux){
        return iMateriaux.addMateriaux(materiaux);
    }
    @PutMapping("/updateMateriaux/{id}")
    public ResponseEntity<Materiaux> updateMateriaux (@PathVariable Integer id , @RequestBody Materiaux materiaux){
        return iMateriaux.updateMateriaux(id ,materiaux);
    }
    @GetMapping("/getMateriauxById/{id}")
    public ResponseEntity<Materiaux> retrieveMateriauxById (@PathVariable("id") Integer id){
        return iMateriaux.retrieveMateriauxById(id);
    }
    @GetMapping("/getAllMateriaux")
    public List<Materiaux> retrieveAllMateriaux(){
        return iMateriaux.retrieveAllMateriaux();
    }

    @DeleteMapping("/deleteMateriauxById/{id}")
    public ResponseEntity<HttpStatus> deleteMateriauxById(@PathVariable ("id") Integer id){
        return iMateriaux.deleteMateriauxById(id);
    }
}
