
package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // Read (byCategory) (employee)
    public Optional<List<Employee>> getEmployeesByCategory(String empCategory) {
        List<Employee> listAllEmployees = employeeRepository.findAll();

        List<Employee> listFilteredEmployees = listAllEmployees
                .stream()
                .filter(e -> e.getEmpCategory().equals(empCategory))
                .collect(Collectors.toList());

        if (listFilteredEmployees.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(listFilteredEmployees);
        }
    }


    // Update (employee)
    public Optional<Employee> editEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = getEmployeeById(employee.getEmpID());

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setEmpSurname(employee.getEmpSurname());
            existingEmployee.setEmpJobTitle(employee.getEmpJobTitle());
            existingEmployee.setEmpCategory(employee.getEmpCategory());
            existingEmployee.setEmpAddress(employee.getEmpAddress());
            existingEmployee.setEmpPhone(employee.getEmpPhone());
            existingEmployee.setEmpEmail(employee.getEmpEmail());
            existingEmployee.setImageUrl(employee.getImageUrl());

            return Optional.of(employeeRepository.save(existingEmployee));
        } else {
            return Optional.empty();
        }
    }

    // Update (employee)
    public Optional<Employee> editEmployeeAddAppointment(Long id, Appointment appointment) {
        Optional<Employee> optionalEmployee = getEmployeeById(id);

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.addAppointments(appointment);

            return Optional.of(employeeRepository.save(existingEmployee));
        } else {
            return Optional.empty();
        }
    }


    // Delete (employee)
    public void deleteEmployee(Long empID) {
        getEmployeeById(empID).ifPresent(employeeToBeDeleted -> employeeRepository.delete(employeeToBeDeleted));
    }



}



//