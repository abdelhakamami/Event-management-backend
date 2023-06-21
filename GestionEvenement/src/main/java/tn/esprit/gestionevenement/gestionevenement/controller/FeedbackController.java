package tn.esprit.gestionevenement.gestionevenement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionevenement.gestionevenement.entities.Feedback;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.repository.UserRepository;
import tn.esprit.gestionevenement.gestionevenement.services.FeedbackService;
import tn.esprit.gestionevenement.gestionevenement.services.ReclamationService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/add/{id}")
    public Feedback  addFeedback(@RequestBody Feedback feedback, @PathVariable("id") Long idUser) {
        return feedbackService.addFeedback(feedback,idUser);
    }

    @PostMapping(path = "/add/user")
    public User addFakeUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{pageNo}/{pageSize}")
    public Page<Feedback> getAll(@PathVariable("pageNo") Integer pageNo,@PathVariable("pageSize") Integer pageSize){
        return feedbackService.getAll(pageNo,pageSize);
    }
}
