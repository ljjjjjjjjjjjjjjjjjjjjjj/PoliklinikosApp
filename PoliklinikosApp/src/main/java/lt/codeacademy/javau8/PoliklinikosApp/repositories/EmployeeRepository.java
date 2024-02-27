package lt.codeacademy.javau8.PoliklinikosApp.repositories;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmpEmail(String empEmail);
}
