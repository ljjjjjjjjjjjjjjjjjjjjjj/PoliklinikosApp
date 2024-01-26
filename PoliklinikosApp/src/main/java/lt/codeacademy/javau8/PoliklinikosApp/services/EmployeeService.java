
package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    public EmployeeRepository employeeRepository;

    public EmployeeService( EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    private final List<Employee> employeesList = new ArrayList<>();
    public List<Employee> getEmployeesDummy() {
        List<Employee> empDummyList = new ArrayList<>();
        Employee doctor1 = new Employee(101L, "Vardenis1", "Pavardenis1", "Doctor" );
        Employee nurse1 = new Employee(102L, "Vardenis2", "Pavardenis2", "Nurse");

        empDummyList.add(doctor1);
        empDummyList.add(nurse1);

        return empDummyList;
    }
    
    ////////////////
    // CRUD methods:
    ////////////////

    // Create
    public Employee addEmployee(Employee employee) {
        employeesList.add(employee);
        return employee;
    }



    // Read (All)
    public List<Employee> getAllEmployees() {
        return employeesList;}
    // Read (byID)
    public Optional<Employee> getEmployeeById(Long empID) {
        Optional<Employee> employeeByID = employeesList.stream().filter(employee -> employee.getEmpID().equals(empID)).findFirst();
        return employeeByID;}


    // Update
    public Employee editEmployee(long empID, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = getEmployeeById(empID);
        if (employeeOptional.isPresent()){
            Employee existingEmployee = employeeOptional.get();

            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setEmpSurname(updatedEmployee.getEmpSurname());
            existingEmployee.setEmpContactInfo(updatedEmployee.getEmpContactInfo());
            existingEmployee.setEmpCategory(updatedEmployee.getEmpCategory());

            return existingEmployee;

        } else {
            return null;
        }
    }

    public Employee editWithDummyData (Employee employee){
        employee.setEmpName("Edited");
        employee.setEmpSurname("Edited");
        employee.setEmpCategory("Edited");
        employee.setEmpContactInfo("Edited");
        return employee;
    }

    // Delete
    public void deleteEmployee(Long empID) {
        Optional<Employee> employeeOptional =  getEmployeeById(empID);

        if (employeeOptional.isPresent()) {
            Employee employeeToBeDeleted = employeeOptional.get();
            employeesList.remove(employeeToBeDeleted);
        }
    }



}
