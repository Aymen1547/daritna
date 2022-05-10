package tn.dari.Controller;

import tn.dari.Model.Appointment;
import tn.dari.Repository.AppointmentRepo;
import tn.dari.Service.AppointmentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentServiceImpl appointmentService;
    @PostMapping("/Lappointment")

    public Appointment addAppointment(@RequestBody Appointment appointment) {

        return appointmentService.addAppointment(appointment);
    }
    @GetMapping("/Aappointment")
    public List<Appointment> GetReclamations(){
        return appointmentService.GetAppointments();
    }

    @DeleteMapping("/Dappointment/{id}")
    public void deleteAppointment(@PathVariable("id") long id){
        appointmentService.deleteAppointment(id);

    }
    @PutMapping("/UPappointment")

    public Appointment updateAppointment(@RequestBody Appointment appointment) {

        return appointmentService.updateAppointment(appointment);
    }
    
   
	@GetMapping("/Llappointment/{title}")
	
	public List<Appointment> getAppointmentByTitle(@PathVariable("title")String title) {


		return appointmentService.findAppointmentBytitle(title);
	}
}
