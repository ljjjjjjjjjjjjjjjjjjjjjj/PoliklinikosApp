
package lt.codeacademy.javau8.PoliklinikosApp;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalService;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.services.EmployeeService;
import lt.codeacademy.javau8.PoliklinikosApp.services.MedicalServiceService;
import lt.codeacademy.javau8.PoliklinikosApp.services.PatientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HomeController {

   PatientService patientService;
   EmployeeService employeeService;
   MedicalServiceService medicalServiceService;

    public HomeController(PatientService patientService, EmployeeService employeeService, MedicalServiceService medicalServiceService){
        this.patientService = patientService;
        this.employeeService = employeeService;
        this.medicalServiceService = medicalServiceService;
    }

    @GetMapping("/patientsAll")
    public List<Patient> getAllPatients() {
        return patientService.getPatientsDummy();
    }

    @GetMapping("/employeesAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployeesDummy();
    }

    @GetMapping("/medicalServicesAll")
    public List<MedicalService> getAllMedicalServices() {
        return medicalServiceService.getMedicalServicesDummy();
    }


}
