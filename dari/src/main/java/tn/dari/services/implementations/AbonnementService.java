package tn.dari.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import tn.dari.entities.Abonnement;
import tn.dari.repositories.AbonnementRepository;
import tn.dari.services.interfaces.IAbonnementService;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbonnementService implements IAbonnementService{
	@Autowired
	AbonnementRepository abonnementRepository;

	@Override
	public Abonnement add(Abonnement abonnement) {
		return abonnementRepository.save(abonnement);
	}

	@Override
	public Abonnement update(Abonnement abonnement) {
		return abonnementRepository.save(abonnement);
	}

	@Override
	public void delete(Abonnement abonnement) {
		abonnementRepository.delete(abonnement);
	}

	@Override
	public List<Abonnement> retrieveAll() {
		return (List<Abonnement>) abonnementRepository.findAll();
	}
	
}
