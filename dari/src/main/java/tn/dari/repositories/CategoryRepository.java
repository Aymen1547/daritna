package tn.dari.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.dari.entities.CategoryFurniture;

public interface CategoryRepository  extends JpaRepository<CategoryFurniture, Long> {
}
