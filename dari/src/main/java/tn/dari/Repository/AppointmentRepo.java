package tn.dari.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.Model.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    @Query("SELECT u FROM Appointment u WHERE u.title LIKE %:title% ")
     List<Appointment> findAppointmentByTitle(@Param("title") String title);
}
