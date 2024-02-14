
package lt.codeacademy.javau8.PoliklinikosApp.controllers;


import lt.codeacademy.javau8.PoliklinikosApp.entities.*;

import lt.codeacademy.javau8.PoliklinikosApp.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

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

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);


    ////////////////////////////////////////////////////////////////////
    //////    Patients     /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////



    // Read (All)  (Employees)
    @GetMapping("/public/employees/get/all")
    public List<Employee> getAllEmployeesPublic() {
        logger.info("getAllEmployees");
        return employeeService.getAllEmployees();}


    // Read (byCategory)  (Employees)
    @GetMapping("/public/employees/get/category/{category}")
    public Optional <List<Employee>> getEmployeesByCategory(@PathVariable("category") String empCategory) {
        logger.info("getEmployeesByCategory");

        return employeeService.getEmployeesByCategory(empCategory);
    }



}
