package tn.dari.Service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.Model.Appointment;
import tn.dari.Model.RDVEntity;
import tn.dari.Repository.ClientRepository;
import tn.dari.Repository.RDVRepositry;
@Service
public class RDVServiceImp implements IRDVService {
	@Autowired
	RDVRepositry AppointmentRepository;
	@Autowired
	ClientRepository ClientRepository;
	private static final Logger l= LogManager.getLogger(RDVServiceImp.class);

	
	@Override
	public List<RDVEntity> retrieveAllAppointment() {
		List<RDVEntity> app=(List<RDVEntity>) AppointmentRepository.findAll();
		for(RDVEntity appointment:app) {
			l.info("appointments +++++++++"+ appointment);}
		
		return app;
	}
	@Override
	//public RDVEntity addRDV(RDVEntity ) {
		//List<RDVEntity> app=(List<RDVEntity>) AppointmentRepository.findAll();
		
		public RDVEntity addRDV(RDVEntity  rdv) {
			return AppointmentRepository.save(rdv);

		/*for(RDVEntity aa:app) {
			//Appointment aa=new Appointment();
		
		if (aa.getDateAppointement().compareTo(a.getDateAppointement()) > 0) {
			
			a.setState("confirmed");
			l.info("appointment is1111111111" + a.getState());
		}
		else if (a.getDateAppointement().compareTo(a.getDateAppointement()) < 0) {
			a.setState("confirmed");
			l.info("appointment is22222222" + a.getState());

			
		}
		else {
			a.setState("not confirmed same date");

			l.info("appointment is333333333" + a.getState());

		}

	}
		AppointmentRepository.save(a);

		return a;*/
	}
	
	public List<RDVEntity> rechercheAppointment(String state) {
		return AppointmentRepository.retrieveAllAppointmentByState(state);}
	@Override
	public void deleteAppointment(String id) {
		AppointmentRepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public RDVEntity retrieveAppointment(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ConfrmerAppointment(Date date) {
		List<RDVEntity> app=(List<RDVEntity>) AppointmentRepository.findAll();

		for(RDVEntity a:app) {
			//Appointment aa=new Appointment();
		
		if (a.getDateAppointement().compareTo(date) > 0) {
			
			a.setState("confirmed");
			l.info("appointment is1111111111" + a.getState());
		}
		else if (a.getDateAppointement().compareTo(date) < 0) {
			a.setState("confirmed");
			l.info("appointment is22222222" + a.getState());

			
		}
		else {
			l.info("appointment is333333333" + a.getState());

		}
		AppointmentRepository.save(a);
		
		}
		
	}
	@Override
	public int countAppointment() {
		int max=0;
		List<RDVEntity> app=(List<RDVEntity>) AppointmentRepository.findAll();
		for(RDVEntity appointment:app) {
			max++;
			
		}
		l.info(" you have "+ max + "appointments");


		return max;
	}
	

}
