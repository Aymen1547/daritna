package tn.dari.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.Model.Abonnement;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement, Long>{

}
