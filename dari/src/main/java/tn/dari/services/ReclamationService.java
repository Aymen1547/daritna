package tn.dari.services;

import java.util.List;
import tn.dari.entity.Reclamation;

public interface ReclamationService {
    public List<Reclamation> GetAllReclamations();

    public Reclamation addReclamation(Reclamation r);

    public Reclamation updateReclamation(Reclamation r);

    public void DeleteReclamation(Long rec);

}
