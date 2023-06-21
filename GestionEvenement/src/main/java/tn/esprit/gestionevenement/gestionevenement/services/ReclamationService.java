package tn.esprit.gestionevenement.gestionevenement.services;

import org.springframework.data.domain.Page;
import tn.esprit.gestionevenement.gestionevenement.entities.Reclamation;

public interface ReclamationService {
    public Reclamation addReclamation(Reclamation reclamation, Long idUser);
    public void deleteReclamation(Long id);
    public Page<Reclamation> getAll(Integer pageNo, Integer pageSize);
}
