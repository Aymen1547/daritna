package tn.dari.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClientEntity implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id; 
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	//private Set<RDVFeedbackEntity> AppointmentFeedBack;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<RDVEntity> Appointment;

}
