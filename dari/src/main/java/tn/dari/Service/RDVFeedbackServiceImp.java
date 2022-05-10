package tn.dari.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.Model.RDVFeedbackEntity;
import tn.dari.Repository.RDVFeedbackRepository;

@Service
public class RDVFeedbackServiceImp implements IRDVFeedbackService  {
	
	@Autowired
	RDVFeedbackRepository AppointmentFeedBackRepository;
	
	private static final Logger l= LogManager.getLogger(RDVServiceImp.class);


	//@Override
	public List<RDVFeedbackEntity> retrieveAllAppointmentFeedBack() {
		List<RDVFeedbackEntity> appF=(List<RDVFeedbackEntity>) AppointmentFeedBackRepository.findAll();
		for(RDVFeedbackEntity appointmentF:appF) {
			l.info("appointmentFeedBacks +++++++++"+ appointmentF);}
		
		return null;
	}
	//@Override
	public RDVFeedbackEntity addAppointmentFeedBack(RDVFeedbackEntity af) {
		List<RDVFeedbackEntity> appF=(List<RDVFeedbackEntity>) AppointmentFeedBackRepository.findAll();
		int max=0;
		for(RDVFeedbackEntity appointmentF:appF) {
			if(appointmentF.isLikes()==true) {
				max++;
			}
			if(max>3) {
				af.setDescriptionFeedBack("good appointment good user");
			
		}
		}
		
		AppointmentFeedBackRepository.save(af);
		return null;
	}

	@Override
	public void deleteAppointmentFeedBack(String id) {
		AppointmentFeedBackRepository.deleteById(Long.parseLong(id));		
		
	}

	@Override
	public RDVFeedbackEntity updateAppointmentFeedBack(RDVFeedbackEntity af) {
		return AppointmentFeedBackRepository.save(af);
	}

	@Override
	public RDVFeedbackEntity retrieveAppointmentFeedBack(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int countLikes() {
		List<RDVFeedbackEntity> appF=(List<RDVFeedbackEntity>) AppointmentFeedBackRepository.findAll();
		int max=0;
		for(RDVFeedbackEntity appointmentF:appF) {
			if(appointmentF.isLikes()==true) {
				max++;
			}}
			l.info("you have +++++++++"+ max+"likes");

		
		
		return max;
	}

}
