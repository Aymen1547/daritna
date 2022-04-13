package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.dari.entities.Furniture;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Long> {
    Furniture findByName(String name);
}
