package tn.dari.services.interfaces;

import java.util.List;

import tn.dari.entities.Abonnement;

public interface IAbonnementService {
	Abonnement add(Abonnement abonnement);
	
	Abonnement update(Abonnement abonnement);

	void delete(Abonnement abonnement);

	List<Abonnement> retrieveAll();
}
