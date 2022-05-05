package tn.dari.Service;

import java.util.List;

import tn.dari.Model.RDVFeedbackEntity;

public interface IRDVFeedbackService {
	List<RDVFeedbackEntity> retrieveAllAppointmentFeedBack();
	RDVFeedbackEntity addAppointmentFeedBack(RDVFeedbackEntity af);

	void deleteAppointmentFeedBack(String id);
	RDVFeedbackEntity updateAppointmentFeedBack(RDVFeedbackEntity af);
	RDVFeedbackEntity retrieveAppointmentFeedBack(String id);
	int countLikes();
}
