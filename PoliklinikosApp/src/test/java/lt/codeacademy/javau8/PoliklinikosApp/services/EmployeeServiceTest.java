package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setEmpID(1L);
        employee1.setEmpName("John");

        Employee employee2 = new Employee();
        employee2.setEmpID(2L);
        employee2.setEmpName("Jane");

        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getEmpName());
        assertEquals("Jane", result.get(1).getEmpName());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.getEmployeeById(1L);

        assertTrue(result.isPresent());
        assertEquals(employee.getEmpName(), result.get().getEmpName());
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.addEmployee(employee);

        assertEquals(employee.getEmpName(), savedEmployee.getEmpName());
    }

    @Test
    public void testGetEmployeesByCategory() {
        // Create sample employees
        Employee employee1 = new Employee();
        employee1.setEmpID(1L);
        employee1.setEmpCategory("Category1");
        Employee employee2 = new Employee();
        employee2.setEmpID(2L);
        employee2.setEmpCategory("Category2");

        // Mock the behavior of the repository
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        // Call the service method
        Optional<List<Employee>> result1 = employeeService.getEmployeesByCategory("Category1");
        Optional<List<Employee>> result2 = employeeService.getEmployeesByCategory("Category3");

        // Verify the results
        assertTrue(result1.isPresent());
        assertEquals(1, result1.get().size());
        assertEquals("Category1", result1.get().get(0).getEmpCategory());
        assertFalse(result2.isPresent());
    }

    @Test
    public void testEditEmployee() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        // Mock the behavior of the repository
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method
        Optional<Employee> result = employeeService.editEmployee(employee);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getEmpName());
    }

    @Test
    public void testEditEmployeeAddAppointment() {
        // Create a sample employee and appointment
        Employee employee = new Employee();
        employee.setEmpID(1L);
        Appointment appointment = new Appointment();

        // Mock the behavior of the repository
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method
        Optional<Employee> result = employeeService.editEmployeeAddAppointment(1L, appointment);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getEmpAppointments().size());
    }

    @Test
    public void testDeleteEmployee() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setEmpID(1L);

        // Mock the behavior of the repository
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        // Call the service method
        employeeService.deleteEmployee(1L);

        // Verify that delete method was called with the correct employee
        verify(employeeRepository, times(1)).delete(employee);
    }
}