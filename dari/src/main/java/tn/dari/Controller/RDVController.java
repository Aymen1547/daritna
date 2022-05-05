package tn.dari.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.Model.RDVEntity;
import tn.dari.Service.RDVServiceImp;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RDVController {
	@Autowired
	RDVServiceImp AppointmentService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-appointment

	@GetMapping("/appointment")
	 @ResponseBody
	 public List<RDVEntity> getAppointments() {
	 List<RDVEntity> list = AppointmentService.retrieveAllAppointment();
	 return list;
	} 
	
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-appointment
		  @PostMapping("/appointment")
		  @ResponseBody
		  public RDVEntity addRDV(@RequestBody RDVEntity rdv) {
			  RDVEntity app = AppointmentService.addRDV(rdv);
			  return app;
		  }
			  
		/*  public RDVEntity addRDV(@RequestBody RDVEntity a,Date date) {
			  RDVEntity app = AppointmentService.addRDV(a,date);
		 return app;
		  }*/
		  
		  //http://localhost:8081/SpringMVC/servlet/remove-user/{user-id}
		  @DeleteMapping("/appointment/{id}")
		   @ResponseBody
		   public void removeAppointment(@PathVariable("id") String id) {
		   AppointmentService.deleteAppointment(id);;
		   }
		  //http://localhost:8081/SpringMVC/servlet/count
		  @GetMapping("/countappointment")
		   @ResponseBody
		   public int CountAppointment() {
		   return AppointmentService.countAppointment();
		   }
		  
		//http://localhost:8081/SpringMVC/servlet/recherche
		  @GetMapping("/recherche")
		   @ResponseBody
			 public List<RDVEntity> rechercheConfirmedAppointments() {
			  List<RDVEntity> list =AppointmentService.rechercheAppointment("confirmed");
		return list;
		   }
		  
		//  : http://localhost:8081/SpringMVC/servlet/BlockUser
		/*  @GetMapping("/BlockUser")
		  @ResponseBody
		  public void BlockUser() {
		  AppointmentService.BlockUserByAttendance();
		 
		  }*/
	

}
