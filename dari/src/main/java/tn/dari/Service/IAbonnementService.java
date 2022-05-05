package tn.dari.Service;

import java.util.List;

import tn.dari.Model.Abonnement;

public interface IAbonnementService {
	Abonnement add(Abonnement abonnement);
	
	Abonnement update(Abonnement abonnement);

	void delete(Abonnement abonnement);

	List<Abonnement> retrieveAll();
}
