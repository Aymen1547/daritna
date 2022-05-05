package tn.dari.Service;

import java.util.List;

import tn.dari.Model.Appointment;

public interface IAppointmentService {
    public void addAppointment (Appointment appointment);
    public void deleteAppointment(Long id);
    public void updateAppointment(Appointment appointment);
    public List<Appointment> findAppointmentByTitle(String title);
}
