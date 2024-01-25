package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {


    public List<Employee> getEmployeesDummy() {
        List<Employee> empDummyList = new ArrayList<>();
        Employee doctor1 = new Employee("Vardenis1", "Pavardenis1", "Doctor" );
        Employee nurse1 = new Employee("Vardenis2", "Pavardenis2", "Nurse");

        empDummyList.add(doctor1);
        empDummyList.add(nurse1);

        return empDummyList;
    }

}
