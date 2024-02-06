
package lt.codeacademy.javau8.PoliklinikosApp.services;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.entities.AppointmentDTO;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.AppointmentRepository;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    public AppointmentRepository appointmentRepository;
    public EmployeeRepository employeeRepository;
    public EmployeeService employeeService;
    public PatientService patientService;

    public AppointmentService(AppointmentRepository appointmentRepository,  EmployeeRepository employeeRepository, EmployeeService employeeService, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
        this.patientService = patientService;

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
            existingAppointment.setAppEmployee(appointment.getAppEmployee());
            existingAppointment.setAppPatient(appointment.getAppPatient());
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


    public Appointment addAppointment(AppointmentDTO dto) {
        Appointment appointment = new Appointment();

        appointment.setAppDate(dto.getAppDate());
        appointment.setAppCategory(dto.getAppCategory());
        appointment.setAppReason(dto.getAppReason());


        Long empID = dto.getAppEmployee();
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(empID);
           if(employeeOptional.isPresent()){
               appointment.setAppEmployee(employeeOptional.get());
           }

        Long patientID = dto.getAppPatient();
        Optional<Patient>patientOptional = patientService.getPatientById(patientID);
        if(patientOptional.isPresent()){
            appointment.setAppPatient(patientOptional.get());
        }

        appointmentRepository.save(appointment);



        return appointment;

    }


}



//
