package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Feedback;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.repository.FeedbackRepository;
import tn.esprit.gestionevenement.gestionevenement.repository.UserRepository;

import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Feedback addFeedback(Feedback feedback, Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            feedback.setUser(user.get());
            return feedbackRepository.save(feedback);
        }
        return null;
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Page<Feedback> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Feedback> pagedResult = feedbackRepository.findAll(paging);
        if (pagedResult.hasContent()){
            return pagedResult;
        }
        return null;
    }

}
