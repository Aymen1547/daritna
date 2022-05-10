package tn.dari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Abonnement;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement, Long>{

}
