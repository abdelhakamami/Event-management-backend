package tn.esprit.gestionevenement.gestionevenement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.repository.UserRepository;
import tn.esprit.gestionevenement.gestionevenement.services.ReclamationService;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/add/{id}")
    public Reclamation  addReclamation(@RequestBody Reclamation reclamation,@PathVariable("id") Long idUser) {
        return reclamationService.addReclamation(reclamation,idUser);
    }

    @PostMapping(path = "/add/user")
    public User addFakeUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        reclamationService.deleteReclamation(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{pageNo}/{pageSize}")
    public Page<Reclamation> getAll(@PathVariable("pageNo") Integer pageNo,@PathVariable("pageSize") Integer pageSize){
        return reclamationService.getAll(pageNo,pageSize);
    }
}
