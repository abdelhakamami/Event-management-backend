package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.data.domain.Page;
import tn.esprit.gestionevenement.gestionevenement.entities.Feedback;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;

public interface FeedbackService {
    public Feedback addFeedback(Feedback feedback, Long idUser);
    public void deleteFeedback(Long id);
    public Page<Feedback> getAll(Integer pageNo, Integer pageSize);
}
