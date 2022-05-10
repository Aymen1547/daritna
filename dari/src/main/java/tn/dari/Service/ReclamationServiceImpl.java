package tn.dari.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.dari.Model.Reclamation;
import tn.dari.Model.User;
import tn.dari.Repository.ReclamationRepository;
@Service

public class ReclamationServiceImpl implements ReclamationService {
    @Autowired
    public ReclamationRepository reclamationRepository;

    public List<Reclamation> GetAllReclamations() {

        return reclamationRepository.findAll();
    }

    public Reclamation addReclamation(Reclamation r) {
        User user = r.getLocation().getUs();
        System.out.println(user);
        return reclamationRepository.save(r);
    }

    public Reclamation updateReclamation(Reclamation r) {

        return reclamationRepository.save(r) ;
    }

    public void DeleteReclamation(Long rec) {
        reclamationRepository.deleteById(rec);

    }

}


