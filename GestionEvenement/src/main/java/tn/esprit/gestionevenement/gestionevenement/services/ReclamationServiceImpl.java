package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;
import tn.esprit.gestionevenement.gestionevenement.entities.User;
import tn.esprit.gestionevenement.gestionevenement.repository.ReclamationRepository;
import tn.esprit.gestionevenement.gestionevenement.repository.UserRepository;

import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService{

    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Reclamation addReclamation(Reclamation reclamation, Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            reclamation.setUser(user.get());
            return reclamationRepository.save(reclamation);
        }
        return null;
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

    @Override
    public Page<Reclamation> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Reclamation> pagedResult = reclamationRepository.findAll(paging);
        if (pagedResult.hasContent()){
            return pagedResult;
        }
        return null;
    }

}
