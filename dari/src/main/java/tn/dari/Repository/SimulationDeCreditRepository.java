package tn.dari.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import tn.dari.Model.SimulationDeCredit;

import java.util.List;


@Repository
public interface SimulationDeCreditRepository extends JpaRepository<SimulationDeCredit, Long> {
    @Query("SELECT nomBank FROM  SimulationDeCredit where nomBank=:name")
    List<String> getAllSimulationByNames(String name);
}