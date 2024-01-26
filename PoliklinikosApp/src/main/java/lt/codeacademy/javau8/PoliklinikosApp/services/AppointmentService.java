
package lt.codeacademy.javau8.PoliklinikosApp.services;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    public AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }



    ////////////////
    // CRUD methods:
    ////////////////

    // Create (Appointment)
    public Appointment addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }



    // Read (All) (Appointment)
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();}

    // Read (byID) (Appointment)
    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        Optional<Appointment> appointmentByID = appointmentRepository.findById(appointmentId);
        return appointmentByID;}


    // Update (Appointment)
    public Optional<Appointment> editAppointment(Appointment appointment) {
        Optional<Appointment> optionalAppointment = getAppointmentById(appointment.getAppID());

        if (optionalAppointment.isPresent()){
            Appointment existingAppointment = optionalAppointment.get();
            existingAppointment.setAppCategory(appointment.getAppCategory());
            existingAppointment.setAppReason(appointment.getAppReason());
            existingAppointment.setAppDate(appointment.getAppDate());

            return Optional.of(appointmentRepository.save(existingAppointment));

        } else {
            return Optional.empty();
        }

    }


    // Delete (Appointment)
    public void deleteAppointment(Long appointmentId) {
        getAppointmentById(appointmentId).ifPresent(appointmentToBeDeleted -> appointmentRepository.delete(appointmentToBeDeleted));

    }





}



//
