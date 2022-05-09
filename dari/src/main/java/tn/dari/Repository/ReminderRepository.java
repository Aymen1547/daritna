package tn.dari.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.Model.User;
import  tn.dari.Model.Reminder;

@Repository("reminderRepository")
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

	List<Reminder> findByEmp(User emp);

}