package tn.dari.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.dari.entities.Furniture;

import java.util.List;


@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Long> {
    Furniture findByName(String name);

    @Query("Select fur FROM Furniture fur WHERE fur.category_id=:cat_id")
    List<Furniture> getByCategoryId(@Param("cat_id")String cat_id);
}