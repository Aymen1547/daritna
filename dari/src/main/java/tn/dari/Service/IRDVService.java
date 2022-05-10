package tn.dari.Service;

import java.util.Date;
import java.util.List;

import tn.dari.Model.RDVEntity;
public interface IRDVService {
	List<RDVEntity> retrieveAllAppointment();
	//RDVEntity addRDV(RDVEntity a,Date date);
	RDVEntity addRDV(RDVEntity rdv);

	void deleteAppointment(String id);
	RDVEntity retrieveAppointment(String id);
	void ConfrmerAppointment(Date date);
	int countAppointment();
	


}
