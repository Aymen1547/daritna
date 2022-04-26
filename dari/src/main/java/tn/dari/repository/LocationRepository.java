package tn.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}