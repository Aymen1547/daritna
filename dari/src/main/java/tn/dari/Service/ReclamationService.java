package tn.dari.Service;

import java.util.List;
import tn.dari.Model.Reclamation;

public interface ReclamationService {
    public List<Reclamation> GetAllReclamations();

    public Reclamation addReclamation(Reclamation r);

    public Reclamation updateReclamation(Reclamation r);

    public void DeleteReclamation(Long rec);

}
