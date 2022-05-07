package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.Model.Reclamation;
import tn.dari.Service.ReclamationServiceImpl;

@RestController


public class ReclamationController {
    @Autowired
    private ReclamationServiceImpl ReclamationService;

    @GetMapping("/all")
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        System.out.println("reception de la requete");
        List<Reclamation> r = ReclamationService.GetAllReclamations();
        return new ResponseEntity<List<Reclamation>>(r, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Reclamation> save(@RequestBody Reclamation r) {
        Reclamation rec = ReclamationService.addReclamation(r);
        return new ResponseEntity<Reclamation>(rec, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Reclamation> update(@RequestBody Reclamation r) {
        Reclamation rec = ReclamationService.updateReclamation(r);
        return new ResponseEntity<Reclamation>(r, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long rec) {
        ReclamationService.DeleteReclamation(rec);
    }
}
