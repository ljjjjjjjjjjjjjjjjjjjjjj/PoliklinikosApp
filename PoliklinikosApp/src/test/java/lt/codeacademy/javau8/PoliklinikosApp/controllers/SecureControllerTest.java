
package lt.codeacademy.javau8.PoliklinikosApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.codeacademy.javau8.PoliklinikosApp.entities.*;
import lt.codeacademy.javau8.PoliklinikosApp.services.AppointmentService;
import lt.codeacademy.javau8.PoliklinikosApp.services.EmployeeService;
import lt.codeacademy.javau8.PoliklinikosApp.services.MedicalProductService;
import lt.codeacademy.javau8.PoliklinikosApp.services.PatientService;
import lt.codeacademy.javau8.PoliklinikosApp.controllers.SecureController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





public class SecureControllerTest {

    @Mock
    private PatientService patientService;
    @Mock
    private EmployeeService employeeService;
    @Mock
    private MedicalProductService medicalProductService;
    @Mock
    private AppointmentService appointmentService;



    @InjectMocks
    private SecureController secureController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(secureController).build();
    }




    ////////////////////////////////////////////////////////////////////
    //////    Patients     /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////



    @Test
    public void testGetAllPatients() throws Exception {
        Patient patient1 = new Patient();
        patient1.setPatientID(1L);
        patient1.setPatientName("John");

        Patient patient2 = new Patient();
        patient2.setPatientID(2L);
        patient2.setPatientName("Jane");

        List<Patient> patients = Arrays.asList(patient1, patient2);

        when(patientService.getAllPatients()).thenReturn(patients);

        mockMvc.perform(get("/logged/patients/get/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].patientID").value(1))
                .andExpect(jsonPath("$[0].patientName").value("John"))
                .andExpect(jsonPath("$[1].patientID").value(2))
                .andExpect(jsonPath("$[1].patientName").value("Jane"));
    }

    @Test
    public void testGetPatientById() throws Exception {
        Patient patient = new Patient();
        patient.setPatientID(1L);
        patient.setPatientName("John");

        when(patientService.getPatientById(1L)).thenReturn(Optional.of(patient));

        mockMvc.perform(get("/logged/patients/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patientID").value(1))
                .andExpect(jsonPath("$.patientName").value("John"));
    }

    @Test
    public void testAddPatient() throws Exception {
        Patient patient = new Patient();
        patient.setPatientID(1L);
        patient.setPatientName("John");

        when(patientService.addPatient(any())).thenReturn(patient);

        mockMvc.perform(post("/logged/patients/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(patient)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patientID").value(1))
                .andExpect(jsonPath("$.patientName").value("John"));
    }



    @Test
    public void testEditPatient() throws Exception {
        // Prepare test data
        Patient patient = new Patient();
        patient.setPatientID(1L);
        patient.setPatientName("John");

        // Mock the service method
        when(patientService.editPatient(any())).thenReturn(Optional.of(patient));

        // Perform the PUT request and verify the results
        mockMvc.perform(put("/logged/patients/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(patient)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patientID").value(1))
                .andExpect(jsonPath("$.patientName").value("John"));
    }

    @Test
    public void testDeletePatient() throws Exception {
        // Perform the DELETE request
        mockMvc.perform(delete("/logged/patients/delete/1"))
                .andExpect(status().isOk());
    }


    ////////////////////////////////////////////////////////////////////
    //////    Employees     ////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////




    @Test
    public void testGetAllEmployeesLogged() throws Exception {
        Employee employee1 = new Employee(1L, "John");

        Employee employee2 = new Employee(2L, "Jane");

        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/logged/employees/get/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].empID").value(1))
                .andExpect(jsonPath("$[0].empName").value("John"))
                .andExpect(jsonPath("$[1].empID").value(2))
                .andExpect(jsonPath("$[1].empName").value("Jane"));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(employee));

        mockMvc.perform(get("/logged/employees/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.empID").value(1))
                .andExpect(jsonPath("$.empName").value("John"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        when(employeeService.addEmployee(any())).thenReturn(employee);

        mockMvc.perform(post("/logged/employees/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.empID").value(1))
                .andExpect(jsonPath("$.empName").value("John"));
    }

    @Test
    public void testEditEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmpID(1L);
        employee.setEmpName("John");

        when(employeeService.editEmployee(any())).thenReturn(Optional.of(employee));

        mockMvc.perform(put("/logged/employees/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.empID").value(1))
                .andExpect(jsonPath("$.empName").value("John"));
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/logged/employees/delete/1"))
                .andExpect(status().isOk());
    }





    ////////////////////////////////////////////////////////////////////
    //////    Appointment     //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////



    @Test
    public void testGetAllAppointments() throws Exception {
        Appointment appointment1 = new Appointment();
        appointment1.setAppID(1L);
        appointment1.setAppCategory("Category 1");

        Appointment appointment2 = new Appointment();
        appointment2.setAppID(2L);
        appointment2.setAppCategory("Category 2");

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2);

        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        mockMvc.perform(get("/logged/appointments/get/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].appID").value(1))
                .andExpect(jsonPath("$[0].appCategory").value("Category 1"))
                .andExpect(jsonPath("$[1].appID").value(2))
                .andExpect(jsonPath("$[1].appCategory").value("Category 2"));
    }

    @Test
    public void testGetAppointmentById() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setAppID(1L);
        appointment.setAppCategory("Category 1");

        when(appointmentService.getAppointmentById(1L)).thenReturn(Optional.of(appointment));

        mockMvc.perform(get("/logged/appointments/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.appID").value(1))
                .andExpect(jsonPath("$.appCategory").value("Category 1"));
    }


        @Test
        public void testAddAppointment() throws Exception {
            AppointmentDTO dto = new AppointmentDTO();
            dto.setAppCategory("Category1");
            dto.setAppReason("Reason1");

            Appointment appointment = new Appointment();
            appointment.setAppCategory(dto.getAppCategory());
            appointment.setAppReason(dto.getAppReason());

            when(appointmentService.addAppointmentDTO(any())).thenReturn(appointment);

            mockMvc.perform(post("/logged/appointments/add-objects")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(dto)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.appCategory").value("Category1"))
                    .andExpect(jsonPath("$.appReason").value("Reason1"));

        }





    ///////////////////////////////////////////////////////////////////
    //////    Medical Products     ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////



    @Test
    public void testGetAllMedicalProducts() throws Exception {
        MedicalProduct product1 = new MedicalProduct();
        product1.setProductID(1L);
        product1.setProductTitle("Product 1");

        MedicalProduct product2 = new MedicalProduct();
        product2.setProductID(2L);
        product2.setProductTitle("Product 2");

        List<MedicalProduct> products = Arrays.asList(product1, product2);

        when(medicalProductService.getAllMedicalProducts()).thenReturn(products);

        mockMvc.perform(get("/logged/medical-products/get/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].productID").value(1))
                .andExpect(jsonPath("$[0].productTitle").value("Product 1"))
                .andExpect(jsonPath("$[1].productID").value(2))
                .andExpect(jsonPath("$[1].productTitle").value("Product 2"));
    }

    @Test
    public void testGetMedicalProductById() throws Exception {
        MedicalProduct product = new MedicalProduct();
        product.setProductID(1L);
        product.setProductTitle("Product 1");

        when(medicalProductService.getMedicalProductById(1L)).thenReturn(Optional.of(product));

        mockMvc.perform(get("/logged/medical-products/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productID").value(1))
                .andExpect(jsonPath("$.productTitle").value("Product 1"));
    }

    @Test
    public void testAddMedicalProduct() throws Exception {
        MedicalProduct product = new MedicalProduct();
        product.setProductID(1L);
        product.setProductTitle("Product 1");

        when(medicalProductService.addMedicalProduct(any())).thenReturn(product);

        mockMvc.perform(post("/logged/medical-products/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productID").value(1))
                .andExpect(jsonPath("$.productTitle").value("Product 1"));
    }

    @Test
    public void testEditMedicalProduct() throws Exception {
        MedicalProduct medicalProduct = new MedicalProduct();
        medicalProduct.setProductID(1L);
        medicalProduct.setProductTitle("Title1");
        medicalProduct.setProductCategory("Category1");


        when(medicalProductService.editMedicalProduct(any())).thenReturn(Optional.of(medicalProduct));

        mockMvc.perform(put("/logged/medical-products/edit/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(medicalProduct)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.productID").value(1))
                .andExpect(jsonPath("$.productTitle").value("Title1"))
                .andExpect(jsonPath("$.productCategory").value("Category1"));

    }


    @Test
    public void testDeleteMedicalProduct() throws Exception {
        mockMvc.perform(delete("/logged/medical-products/delete/1"))
                .andExpect(status().isOk());
    }













}

// Double check after app changes