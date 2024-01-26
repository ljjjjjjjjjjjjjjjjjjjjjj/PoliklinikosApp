
package lt.codeacademy.javau8.PoliklinikosApp.controllers;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalProduct;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.services.EmployeeService;
import lt.codeacademy.javau8.PoliklinikosApp.services.MedicalProductService;
import lt.codeacademy.javau8.PoliklinikosApp.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class HomeController {

   PatientService patientService;
   EmployeeService employeeService;
   MedicalProductService medicalProductService;

    public HomeController(PatientService patientService, EmployeeService employeeService, MedicalProductService medicalProductService){
        this.patientService = patientService;
        this.employeeService = employeeService;
        this.medicalProductService = medicalProductService;
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
    //////    Medical Services     ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    // Create      (Medical Services)
    @PostMapping("/medicalProducts/add")
    public MedicalProduct addMedicalService(@RequestBody MedicalProduct medicalProduct) {
        return medicalProductService.addMedicalProduct(medicalProduct);
    }


    // Read (All)  (Medical Services)
    @GetMapping("/medicalProducts/get/All")
    public List<MedicalProduct> getAllMedicalProducts() {
        return medicalProductService.getAllMedicalProducts();
    }


    // Read (byID) (Medical Services)
    @GetMapping("/medicalProducts/get/{id}")
    public Optional<MedicalProduct> getMedicalSProductById(@PathVariable("id") long id) {
        return medicalProductService.getMedicalProductById(id);
    }


    // Update (Medical Services)
    @PutMapping("/medicalProducts/edit/{id}")
    public void editMedicalProduct(@PathVariable("id") long id, @RequestBody MedicalProduct medicalProduct) {
        medicalProductService.editMedicalProduct(medicalProduct);
    }


    // Delete (Medical Services)
    @DeleteMapping("/medicalServices/delete/{id}")
    public void deleteMedicalService(@PathVariable ("id") long id) {
            medicalProductService.deleteMedicalProduct(id);
    }

}
