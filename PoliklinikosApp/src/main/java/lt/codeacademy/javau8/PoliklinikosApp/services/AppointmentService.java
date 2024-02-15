
package lt.codeacademy.javau8.PoliklinikosApp.services;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.entities.AppointmentDTO;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.AppointmentRepository;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    // Create (Appointment) - WITH OBJECTS
    public Appointment addAppointmentDTO(AppointmentDTO dto) {
        Appointment appointment = new Appointment();

        appointment.setAppDate(dto.getAppDate());
        appointment.setAppCategory(dto.getAppCategory());
        appointment.setAppReason(dto.getAppReason());


        Long empID = dto.getAppEmployeeID();
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(empID);
        if(employeeOptional.isPresent()){
            appointment.setAppEmployee(employeeOptional.get());
        }

        Long patientID = dto.getAppPatientID();
        Optional<Patient>patientOptional = patientService.getPatientById(patientID);
        if(patientOptional.isPresent()){
            appointment.setAppPatient(patientOptional.get());
        }

        appointmentRepository.save(appointment);



        return appointment;

    }



    // Read (All) (Appointment)
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();}


    // Read (All) (Appointment) - WITH OBJECTS
    public List<AppointmentDTO> getAllAppointmentsObjects() {
        List<Appointment> appointmentsList = appointmentRepository.findAll();
        List<AppointmentDTO> dtoList = new ArrayList<>();

        for (Appointment appointment : appointmentsList) {
           AppointmentDTO dto = fromAppointmentToDTO(appointment);
           dtoList.add(dto);
        }

        return dtoList;
    }




    // Read (byID) (Appointment)
    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        Optional<Appointment> appointmentByID = appointmentRepository.findById(appointmentId);
        return appointmentByID;}



    // Read (byID) (Appointment) - WITH OBJECTS
    public Optional<AppointmentDTO> getAppointmentByIdObjectsDTO(Long appointmentId) {
        Optional<Appointment> appointmentByIDoptional = appointmentRepository.findById(appointmentId);
        AppointmentDTO dtoExisting = new AppointmentDTO();

        if (appointmentByIDoptional.isPresent()){
            Appointment appointmentExisting = appointmentByIDoptional.get();
            dtoExisting = fromAppointmentToDTO(appointmentExisting);
            return Optional.of(dtoExisting);
        }
      return Optional.of(dtoExisting);
    }


    // Read (All) (Appointment) - WITH OBJECTS
    public List<AppointmentDTO> getAllAppointmentsByPatientDTO(Long appointmentId) {
        List<Appointment> appointmentsList = appointmentRepository.findAll();
        List<AppointmentDTO> dtoList = new ArrayList<>();

        for (Appointment appointment : appointmentsList) {
            if (appointment.getAppPatient().getPatientID().equals(appointmentId)) {
                AppointmentDTO dto = fromAppointmentToDTO(appointment);
                dtoList.add(dto);
            }
        }

        return dtoList;
    }





    // Method from App to DTO
    public AppointmentDTO fromAppointmentToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setAppID(appointment.getAppID());
        dto.setAppCategory(appointment.getAppCategory());
        dto.setAppReason(appointment.getAppReason());
        dto.setAppDate(appointment.getAppDate());

        // Set employee info
        if (appointment.getAppEmployee() != null) {
            Employee employee = appointment.getAppEmployee();
            dto.setAppEmployeeID(employee.getEmpID());
            dto.setEmpName(employee.getEmpName());
            dto.setEmpSurname(employee.getEmpSurname());
            dto.setEmpJobTitle(employee.getEmpJobTitle());
            dto.setEmpCategory(employee.getEmpCategory());
        }

        // Set patient info
        if (appointment.getAppPatient() != null) {
            Patient patient = appointment.getAppPatient();
            dto.setAppPatientID(patient.getPatientID());
            dto.setPatientName(patient.getPatientName());
            dto.setPatientSurname(patient.getPatientSurname());
            dto.setPatientNO(patient.getPatientNO());
        }

        return dto;
    }




    // Update (Appointment)  - WITH OBJECTS   ( DTO - to - app )
    public Optional <Appointment> editAppointmentWithObjectsDTO(AppointmentDTO dto) {
        Long appID = dto.getAppID();
        Optional <Appointment> optionalAppointment = appointmentRepository.findById(appID);

        if (optionalAppointment.isPresent()) {
            Appointment existingAppointment = optionalAppointment.get();

            existingAppointment.setAppCategory(dto.getAppCategory());
            existingAppointment.setAppReason(dto.getAppReason());
            existingAppointment.setAppDate(dto.getAppDate());

            if (dto.getAppEmployeeID() != null) {
                Long empID = dto.getAppEmployeeID();
                Optional <Employee> employeeOptional = employeeService.getEmployeeById(empID);

                if(employeeOptional.isPresent()){
                   Employee empExisting = employeeOptional.get();
                   existingAppointment.setAppEmployee(empExisting);
                }
            }

            if (dto.getAppPatientID() != null) {
                Long patientID = dto.getAppPatientID();
                Optional <Patient> patientOptional = patientService.getPatientById(patientID);

                if(patientOptional.isPresent()){
                    Patient patientExisting = patientOptional.get();
                    existingAppointment.setAppPatient(patientExisting);
                }
            }


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
