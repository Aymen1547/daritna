package tn.dari.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import tn.dari.entities.Abonnement;
import tn.dari.services.implementations.AbonnementService;

@RestController
@RequestMapping("/abonnement")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbonnementController {
	@Autowired
	AbonnementService abonnementService;

	@PostMapping("/add")
	public ResponseEntity<Abonnement> add(@RequestBody Abonnement abonnement) {
		Abonnement abonnementSaved = abonnementService.add(abonnement);
		if (abonnementSaved != null)
			return new ResponseEntity<>(abonnementSaved, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/update")
	public ResponseEntity<Abonnement> update(@RequestBody Abonnement abonnement) {
		Abonnement abonnementUpdated = abonnementService.update(abonnement);
		if (abonnementUpdated != null) {
			return new ResponseEntity<>(abonnementUpdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Abonnement abonnement) {
		abonnementService.delete(abonnement);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/retrieveAll")
	public ResponseEntity<List<Abonnement>> retrieveAll() {
		List<Abonnement> abonnementRetreived = abonnementService.retrieveAll();
		return new ResponseEntity<>(abonnementRetreived, HttpStatus.OK);
	}
}
