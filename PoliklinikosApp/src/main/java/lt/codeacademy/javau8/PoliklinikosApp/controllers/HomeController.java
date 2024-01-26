
package lt.codeacademy.javau8.PoliklinikosApp.controllers;


import lt.codeacademy.javau8.PoliklinikosApp.entities.*;

import lt.codeacademy.javau8.PoliklinikosApp.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class HomeController {

   PatientService patientService;
   EmployeeService employeeService;
   MedicalProductService medicalProductService;
   AppointmentService appointmentService;
   // Upcoming_Updates_MedicalRecordService medicalRecordService;

    public HomeController (PatientService patientService, EmployeeService employeeService, MedicalProductService medicalProductService, AppointmentService appointmentService){
        this.patientService = patientService;
        this.employeeService = employeeService;
        this.medicalProductService = medicalProductService;
        this.appointmentService = appointmentService;

    }


    ////////////////////////////////////////////////////////////////////
    //////    Patients     /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    // Create      (Patients)
    @PostMapping("/patients/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);}


    // Read (All)  (Patients)
    @GetMapping("/patients/get/All")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();}


    // Read (byID) (Patients)
    @GetMapping("/patients/get/{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") long id) {
        return patientService.getPatientById(id);
    }


    // Update (Patients)
    @PutMapping("/patients/edit/{id}")
    public Optional<Patient> editPatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        return patientService.editPatient(patient);
    }


    // Delete (Patients)
    @DeleteMapping("/patients/delete/{id}")
    public void deletePatient(@PathVariable("id") long id) {
        patientService.deletePatient(id);
    }



    ////////////////////////////////////////////////////////////////////
    //////    Employees     ////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    // Create      (Employees)
    @PostMapping("/employees/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);}



    // Read (All)  (Employees)
    @GetMapping("/employees/get/All")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();}



    // Read (byID) (Employees)
    @GetMapping("/employees/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") long id) {
        return employeeService.getEmployeeById(id);
    }


    // Update (Employees)
    @PutMapping("/employees/edit/{id}")
    public Optional<Employee> editEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return employeeService.editEmployee(employee);
    }


    // Delete (Employee)
    @DeleteMapping("employees/delete/{id}")
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }




    ///////////////////////////////////////////////////////////////////
    //////    Medical Products     ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    // Create      (Medical Products)
    @PostMapping("/medicalProducts/add")
    public MedicalProduct addMedicalService(@RequestBody MedicalProduct medicalProduct) {
        return medicalProductService.addMedicalProduct(medicalProduct);
    }


    // Read (All)  (Medical Products)
    @GetMapping("/medicalProducts/get/All")
    public List<MedicalProduct> getAllMedicalProducts() {
        return medicalProductService.getAllMedicalProducts();
    }


    // Read (byID) (Medical Products)
    @GetMapping("/medicalProducts/get/{id}")
    public Optional<MedicalProduct> getMedicalSProductById(@PathVariable("id") long id) {
        return medicalProductService.getMedicalProductById(id);
    }


    // Update (Medical Products)
    @PutMapping("/medicalProducts/edit/{id}")
    public void editMedicalProduct(@PathVariable("id") long id, @RequestBody MedicalProduct medicalProduct) {
        medicalProductService.editMedicalProduct(medicalProduct);
    }


    // Delete (Medical Products)
    @DeleteMapping("/medicalProducts/delete/{id}")
    public void deleteMedicalService(@PathVariable ("id") long id) {
            medicalProductService.deleteMedicalProduct(id);
    }




    ////////////////////////////////////////////////////////////////////
    //////    Appointment     //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////



    // Create      (Appointments)
    @PostMapping("/appointments/add")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);}



    // Read (All)  (Appointments)
    @GetMapping("/appointments/get/All")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();}



    // Read (byID) (Appointments)
    @GetMapping("/appointments/get/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable("id") long id) {
        return appointmentService.getAppointmentById(id);
    }


    // Update (Appointments)
    @PutMapping("/appointments/edit/{id}")
    public Optional<Appointment> editAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
        return appointmentService.editAppointment(appointment);
    }


    // Delete (Appointment)
    @DeleteMapping("appointments/delete/{id}")
    public void deleteAppointment(@PathVariable("id") long id) {
        appointmentService.deleteAppointment(id);
    }










    ///////////////////////////////////////////////////////////////////
    //////    Medical Records     ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    /*


    // Create      (Medical Records)
    @PostMapping("/medicalRecords/add")
    public Upcoming_Updates_MedicalRecord addMedicalService(@RequestBody Upcoming_Updates_MedicalRecord medicalRecord) {
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }


    // Read (All)  (Medical Records)
    @GetMapping("/medicalRecords/get/All")
    public List<Upcoming_Updates_MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }


    // Read (byID) (Medical Records)
    @GetMapping("/medicalRecords/get/{id}")
    public Optional<Upcoming_Updates_MedicalRecord> getMedicalSRecordById(@PathVariable("id") long id) {
        return medicalRecordService.getMedicalRecordById(id);
    }


    // Update (Medical Records)
    @PutMapping("/medicalRecords/edit/{id}")
    public void editMedicalRecord(@PathVariable("id") long id, @RequestBody Upcoming_Updates_MedicalRecord medicalRecord) {
        medicalRecordService.editMedicalRecord(medicalRecord);
    }


    // Delete (Medical Records)
    @DeleteMapping("/medicalRecords/delete/{id}")
    public void deleteMedicalRecord(@PathVariable ("id") long id) {
        medicalRecordService.deleteMedicalRecord(id);
    }




*/






}
