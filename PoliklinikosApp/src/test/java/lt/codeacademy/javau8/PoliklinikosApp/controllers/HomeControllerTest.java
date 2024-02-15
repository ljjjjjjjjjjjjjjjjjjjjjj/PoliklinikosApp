
package lt.codeacademy.javau8.PoliklinikosApp.controllers;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.services.EmployeeService;
import lt.codeacademy.javau8.PoliklinikosApp.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;



public class HomeControllerTest {

    @Mock
    private EmployeeService employeeService;
    @Mock
    private PatientService patientService;


    @InjectMocks
    private HomeController homeController;

    private MockMvc mockMvc;



    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }






    @Test
    public void testGetAllEmployeesPublic() throws Exception {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        List<Employee> employees = Collections.singletonList(employee);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/public/employees/get/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].empID").value(1))
                .andExpect(jsonPath("$[0].empName").value("John"));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void testGetEmployeesByCategory() throws Exception {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        List<Employee> employees = Collections.singletonList(employee);

        when(employeeService.getEmployeesByCategory("category")).thenReturn(Optional.of(employees));

        mockMvc.perform(MockMvcRequestBuilders.get("/public/employees/get/category/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].empID").value(1))
                .andExpect(jsonPath("$[0].empName").value("John"));

        verify(employeeService, times(1)).getEmployeesByCategory("category");
    }
}