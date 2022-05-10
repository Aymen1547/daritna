package tn.dari.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.Model.RDVEntity;
@Repository
public interface RDVRepositry extends CrudRepository<RDVEntity,Long>{
	@Query("SELECT a FROM RDVEntity a WHERE a.state=:confirmed ")
	List<RDVEntity> retrieveAllAppointmentByState(@Param("confirmed")String State);
	
	// @Query("SELECT u FROM Appointment u WHERE u.title LIKE %:title% ")
    // List<RDVEntity> findAppointmentByTitle(@Param("title") String title);

}

