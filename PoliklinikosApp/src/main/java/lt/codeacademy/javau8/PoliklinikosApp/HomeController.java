
package lt.codeacademy.javau8.PoliklinikosApp;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalService;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.services.EmployeeService;
import lt.codeacademy.javau8.PoliklinikosApp.services.MedicalServiceService;
import lt.codeacademy.javau8.PoliklinikosApp.services.PatientService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/patientsDummyAll")
    public List<Patient> getAllPatientsDummy() {
        return patientService.getPatientsDummy();
    }

    @GetMapping("/employeesDummyAll")
    public List<Employee> getAllEmployeesDummy() {
        return employeeService.getEmployeesDummy();
    }

    @GetMapping("/medicalServicesDummyAll")
    public List<MedicalService> getAllMedicalServicesDummy() {
        return medicalServiceService.getMedicalServicesDummy();
    }




    ////////////////////////////////////////////////////////////////////
    //////    Patients     /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    // Create      (Patients)
    @PostMapping("/patients/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);}

    /*  Dummy data
    {
        "patientID": "10001",
            "patientName": "AtnaujintasVardenis",
            "patientSurname": "AtnaujintasPavardenis",
            "patientContactInfo": "Vilnius",
            "patientCategory": "New Patient"
    }
    {
    "patientID": "10001",
    "patientName": "NaujasVardenis",
    "patientSurname": "NaujasPavardenis",
    "patientContactInfo": "Vilnius",
    "patientCategory": "New Patient"
}
    */

    // Read (All)  (Patients)
    @GetMapping("/patients/get/All")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();}


    // Read (byID) (Patients)
    @GetMapping("/patients/get/{id}")
    public Patient getPatientById(@PathVariable("id") long id, Model model) {
        try {Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));

            model.addAttribute("patient", patient );
            return patient;

        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Update
    @PutMapping("/patients/edit/{id}")
    public Patient editPatient(@PathVariable("id") long id, @RequestBody Patient updatedPatient) {
        Patient editedPatient = patientService.editPatient(id, updatedPatient);
        return editedPatient;
    }

    // Delete
    @DeleteMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        Optional <Patient> patientOptional = patientService.getPatientById(id);
        if (patientOptional.isPresent()){
        patientService.deletePatient(id);
        return ("Patient ID" + id + " was deleted");
        }else  {
            return ("Patient ID" + id + " was not found");
        }

    }



    ////////////////////////////////////////////////////////////////////
    //////    Employees     ////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    // Create      (Employees)
    @PostMapping("/employees/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);}

    /*  Dummy data
    {
        "empID": "10001",
            "empName": "AtnaujintasVardenis",
            "empSurname": "AtnaujintasPavardenis",
            "empContactInfo": "Vilnius",
            "empCategory": "Seimos gydytojas"
    }
    {
    "empID": "10001",
    "empName": "NaujasVardenis",
    "empSurname": "NaujasPavardenis",
    "empContactInfo": "Vilnius",
    "empCategory": "Odontologas"
}
    */

    // Read (All)  (Employees)
    @GetMapping("/employees/get/All")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();}


    // Read (byID) (Employees)
    @GetMapping("/employees/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id, Model model) {
        try {Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID:" + id));

            model.addAttribute("employee", employee );
            return employee;

        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Update (Employees)
    @PutMapping("/employees/edit/{id}")
    public Employee editEmployee(@PathVariable("id") long id, @RequestBody Employee updatedEmployee) {
        Employee editedEmployee = employeeService.editEmployee(id, updatedEmployee);
        return editedEmployee;
    }

    // Delete (Employees)
    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Optional <Employee> employeeOptional = employeeService.getEmployeeById(id);
        if (employeeOptional.isPresent()){
            employeeService.deleteEmployee(id);
            return ("Employee ID " + id + " was deleted");
        }else  {
            return ("Employee ID " + id + " was not found");
        }

    }

    ///////////////////////////////////////////////////////////////////
    //////    Medical Services     ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    // Create      (Medical Services)
    @PostMapping("/medicalServices/add")
    public MedicalService addMedicalService(@RequestBody MedicalService medicalService) {
        return medicalServiceService.addMedicalService(medicalService);
    }

/*  Dummy data
{
    "servicesID": "10001",
    "servicesTitle": "AtnaujintiTyrimai",
    "servicesCategory": "Tyrimai"
}
{
    "servicesID": "10002",
    "servicesTitle": "NaujiKonsultacija",
    "servicesCategory": "Konsultacijos"
}
*/

    // Read (All)  (Medical Services)
    @GetMapping("/medicalServices/get/All")
    public List<MedicalService> getAllMedicalServices() {
        return medicalServiceService.getAllMedicalServices();
    }

    // Read (byID) (Medical Services)
    @GetMapping("/medicalServices/get/{id}")
    public MedicalService getMedicalServiceById(@PathVariable("id") long id, Model model) {
        try {
            MedicalService medicalService = medicalServiceService.getMedicalServiceById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid medical service ID:" + id));

            model.addAttribute("medicalService", medicalService);
            return medicalService;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Update (Medical Services)
    @PutMapping("/medicalServices/edit/{id}")
    public MedicalService editMedicalService(@PathVariable("id") long id, @RequestBody MedicalService updatedMedicalService) {
        MedicalService editedMedicalService = medicalServiceService.editMedicalService(id, updatedMedicalService);
        return editedMedicalService;
    }

    // Delete (Medical Services)
    @DeleteMapping("/medicalServices/delete/{id}")
    public String deleteMedicalService(@PathVariable Long id) {
        Optional<MedicalService> medicalServiceOptional = medicalServiceService.getMedicalServiceById(id);
        if (medicalServiceOptional.isPresent()) {
            medicalServiceService.deleteMedicalService(id);
            return ("Medical Service ID " + id + " was deleted");
        } else {
            return ("Medical Service ID " + id + " was not found");
        }
    }

}
