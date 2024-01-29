
package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    public EmployeeRepository employeeRepository;

    public EmployeeService( EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    
    ////////////////
    // CRUD methods:
    ////////////////



    // Create (employee)
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }



    // Read (All) (employee)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();}


    // Read (byID) (employee)
    public Optional<Employee> getEmployeeById(Long empID) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empID);
        return employeeOptional;
    }


    // Update (employee)
    public Optional<Employee> editEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = getEmployeeById(employee.getEmpID());

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setEmpSurname(employee.getEmpSurname());
            existingEmployee.setEmpCategory(employee.getEmpCategory());
            existingEmployee.setEmpContactInfo(employee.getEmpContactInfo());
            existingEmployee.setImageUrl(employee.getImageUrl());

            return Optional.of(employeeRepository.save(existingEmployee));
        } else {
            return Optional.empty();
        }
    }
    /*
    // Update (employee)
    public void editEmployee(Employee employee) {

        getEmployeeById(employee.getEmpID())
                .ifPresent(e -> {
                    e.setEmpName(employee.getEmpName());
                    e.setEmpSurname(employee.getEmpSurname());
                    e.setEmpCategory(employee.getEmpCategory());
                    e.setEmpContactInfo(employee.getEmpContactInfo());

                    employeeRepository.save(e);
                });
    }
    */


    // Delete (employee)
    public void deleteEmployee(Long empID) {
        getEmployeeById(empID).ifPresent(employeeToBeDeleted -> employeeRepository.delete(employeeToBeDeleted));
    }



}



//