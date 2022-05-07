package tn.dari.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.Model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}