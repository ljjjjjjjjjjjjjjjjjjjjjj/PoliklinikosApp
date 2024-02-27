

package lt.codeacademy.javau8.PoliklinikosApp.controllers;


import lt.codeacademy.javau8.PoliklinikosApp.entities.*;
import lt.codeacademy.javau8.PoliklinikosApp.services.AppointmentService;
import lt.codeacademy.javau8.PoliklinikosApp.services.EmployeeService;
import lt.codeacademy.javau8.PoliklinikosApp.services.MedicalProductService;
import lt.codeacademy.javau8.PoliklinikosApp.services.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

@CrossOrigin(origins = "http://localhost:3000/")
public class SecureController {

    private static final Logger logger = LoggerFactory.getLogger(SecureController.class);

    PatientService patientService;
    EmployeeService employeeService;
    MedicalProductService medicalProductService;
    AppointmentService appointmentService;


    public SecureController(PatientService patientService, EmployeeService employeeService, MedicalProductService medicalProductService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.employeeService = employeeService;
        this.medicalProductService = medicalProductService;
        this.appointmentService = appointmentService;

    }

    private static final Logger log = LoggerFactory.getLogger(SecureController.class);


    ////////////////////////////////////////////////////////////////////
    //////    Patients     /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    // Create      (Patients)
    @PostMapping("logged/patients/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }


    // Read (All)  (Patients)
    @GetMapping("logged/patients/get-all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }


    // Read (byID) (Patients)
    @GetMapping("logged/patients/get-id/{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") long id) {
        return patientService.getPatientById(id);
    }

    // Read (byEmail) (Patients)
    @GetMapping("logged/patients/get-email/{patientEmail}")
    public Optional<Patient> getPatientByEmail(@PathVariable("patientEmail") String patientEmail) {
        logger.info("getPatientByEmail");
        return patientService.getPatientByEmail(patientEmail);
    }

    // Read (byName) (Patients)
    @GetMapping("logged/patients/get-name/{name}")
    public Optional<List<Patient>> getPatientsByName(@PathVariable("name") String patientName) {
        logger.info("getPatientsByName");
        return patientService.getPatientsByName(patientName);
    }


    // Update (Patients)
    @PutMapping("logged/patients/edit/{id}")
    public Optional<Patient> editPatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        return patientService.editPatient(patient);
    }


    // Delete (Patients)
    @DeleteMapping("logged/patients/delete/{id}")
    public void deletePatient(@PathVariable("id") long id) {
        patientService.deletePatient(id);
    }


    ////////////////////////////////////////////////////////////////////
    //////    Employees     ////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    // Create      (Employees)
    @PostMapping("logged/employees/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("addEmployee");
        return employeeService.addEmployee(employee);
    }


    // Read (All)  (Employees)
    @GetMapping("logged/employees/get-all")
    public List<Employee> getAllEmployeesLogged() {
        logger.info("getAllEmployees");
        return employeeService.getAllEmployees();
    }


    // Read (byCategory)  (Employees)
    @GetMapping("logged/employees/get-category/{category}")
    public Optional<List<Employee>> getEmployeesByCategory(@PathVariable("category") String empCategory) {
        logger.info("getEmployeesByCategory");

        return employeeService.getEmployeesByCategory(empCategory);
    }


    // Read (byID) (Employees)
    @GetMapping("logged/employees/get-id/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") long id) {
        logger.info("getEmployeeById");
        return employeeService.getEmployeeById(id);
    }

    // Read (byEmail) (Employees)
    @GetMapping("logged/employees/get-email/{empEmail}")
    public Optional<Employee> getEmployeeByEmail(@PathVariable("empEmail") String empEmail) {
        logger.info("getEmployeeByEmail");
        return employeeService.getEmployeeByEmail(empEmail);
    }


    // Update (Employees)
    @PutMapping("logged/employees/edit/{id}")
    public Optional<Employee> editEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        logger.info("editEmployee");
        return employeeService.editEmployee(employee);
    }


    // Update / Add Appointment (Employees)
    @PutMapping("logged/employees/edit/add-appointment/{id}")
    public Optional<Employee> editEmployeeAddAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
        logger.info("editEmployee-addAppointment");
        return employeeService.editEmployeeAddAppointment(id, appointment);
    }


    // Delete (Employee)
    @DeleteMapping("logged/employees/delete/{id}")
    public void deleteEmployee(@PathVariable("id") long id) {
        logger.info("deleteEmployee");
        employeeService.deleteEmployee(id);
    }




    ////////////////////////////////////////////////////////////////////
    //////    Appointment     //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////


    // Create      (Appointments)
    @PostMapping("logged/appointments/add-objects")
    public Appointment addAppointment(@RequestBody AppointmentDTO dto) {

        return appointmentService.addAppointmentDTO(dto);
    }


    // Read (All)  (Appointments)
    @GetMapping("logged/appointments/get/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }


    // Read (All)  (Appointments) - WITH OBJECTS
    @GetMapping("logged/appointments/get/all-objects")
    public List<AppointmentDTO> getAllAppointmentsObjects() {
        return appointmentService.getAllAppointmentsObjects();
    }


    // Read (byID) (Appointments)
    @GetMapping("logged/appointments/get/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable("id") long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Read (byID) (Appointments) - WITH OBJECTS
    @GetMapping("logged/appointments/get/objects/{id}")
    public Optional<AppointmentDTO> getAppointmentByIdObjectsDTO(@PathVariable("id") long id) {
        return appointmentService.getAppointmentByIdObjectsDTO(id);
    }


    // Read (byPATIENT)  (Appointments) - WITH OBJECTS
    @GetMapping("logged/appointments/get/all-patient-objects/{id}")
    public List<AppointmentDTO> getAllAppointmentsByPatientObjects(@PathVariable("id") long id) {
        return appointmentService.getAllAppointmentsByPatientDTO(id);
    }






    // Update (Appointments) - WITH OBJECTS
    @PutMapping("logged/appointments/edit/objects{id}")
    public Optional<Appointment> editAppointment(@PathVariable("id") long id, @RequestBody AppointmentDTO dto) {
        return appointmentService.editAppointmentWithObjectsDTO(dto);
    }


    // Delete (Appointment)
    @DeleteMapping("logged/appointments/delete/{id}")
    public void deleteAppointment(@PathVariable("id") long id) {
        appointmentService.deleteAppointment(id);
    }




    ///////////////////////////////////////////////////////////////////
    //////    Medical Products     ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    // Create      (Medical Products)
    @PostMapping("logged/medical-products/add")
    public MedicalProduct addMedicalService(@RequestBody MedicalProduct medicalProduct) {
        return medicalProductService.addMedicalProduct(medicalProduct);
    }


    // Read (All)  (Medical Products)
    @GetMapping("logged/medical-products/get/all")
    public List<MedicalProduct> getAllMedicalProducts() {
        return medicalProductService.getAllMedicalProducts();
    }


    // Read (byID) (Medical Products)
    @GetMapping("logged/medical-products/get/{id}")
    public Optional<MedicalProduct> getMedicalSProductById(@PathVariable("id") long id) {
        return medicalProductService.getMedicalProductById(id);
    }


    // Update (Medical Products)
    @PutMapping("logged/medical-products/edit/{id}")
    public  Optional<MedicalProduct> editMedicalProduct(@PathVariable("id") long id, @RequestBody MedicalProduct medicalProduct) {
        return medicalProductService.editMedicalProduct(medicalProduct);
    }




    // Delete (Medical Products)
    @DeleteMapping("logged/medical-products/delete/{id}")
    public void deleteMedicalService(@PathVariable("id") long id) {
        medicalProductService.deleteMedicalProduct(id);
    }




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







