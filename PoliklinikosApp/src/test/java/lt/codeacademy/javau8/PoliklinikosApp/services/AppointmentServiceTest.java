package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import lt.codeacademy.javau8.PoliklinikosApp.entities.AppointmentDTO;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.AppointmentRepository;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {
    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private AppointmentService appointmentService;

    private Appointment appointment;
    private AppointmentDTO appointmentDTO;
    private List<Appointment> appointmentList;

    @BeforeEach
    void setUp() {
        appointment = new Appointment();
        appointment.setAppID(1L);
        appointment.setAppCategory("Category");
        appointment.setAppReason("Reason");
        appointment.setAppDate("Date");

        Employee employee = new Employee();
        employee.setEmpID(1L);
        appointment.setAppEmployee(employee);

        Patient patient = new Patient();
        patient.setPatientID(1L);
        appointment.setAppPatient(patient);

        appointmentDTO = new AppointmentDTO();
        appointmentDTO.setAppID(1L);
        appointmentDTO.setAppCategory("Category");
        appointmentDTO.setAppReason("Reason");
        appointmentDTO.setAppDate("Date");
        appointmentDTO.setAppEmployeeID(1L);
        appointmentDTO.setAppPatientID(1L);

        appointmentList = Arrays.asList(appointment);
    }

    @Test
    void testAddAppointment() {
        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        Appointment savedAppointment = appointmentService.addAppointment(appointment);

        assertEquals(appointment, savedAppointment);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void testAddAppointmentDTO() {
        when(employeeService.getEmployeeById(anyLong())).thenReturn(Optional.of(new Employee()));
        when(patientService.getPatientById(anyLong())).thenReturn(Optional.of(new Patient()));
        when(appointmentRepository.save(any())).thenReturn(appointment);

        Appointment savedAppointment = appointmentService.addAppointmentDTO(appointmentDTO);

        assertEquals(appointment.getAppCategory(), savedAppointment.getAppCategory());
        assertEquals(appointment.getAppReason(), savedAppointment.getAppReason());
        assertEquals(appointment.getAppDate(), savedAppointment.getAppDate());
        verify(appointmentRepository, times(1)).save(any());
    }

    @Test
    void testGetAllAppointments() {
        when(appointmentRepository.findAll()).thenReturn(appointmentList);

        List<Appointment> appointments = appointmentService.getAllAppointments();

        assertEquals(appointmentList, appointments);
        verify(appointmentRepository, times(1)).findAll();
    }

    @Test
    void testGetAllAppointmentsObjects() {
        when(appointmentRepository.findAll()).thenReturn(appointmentList);

        List<AppointmentDTO> appointmentDTOList = appointmentService.getAllAppointmentsObjects();

        assertEquals(1, appointmentDTOList.size());
        verify(appointmentRepository, times(1)).findAll();
    }

    @Test
    void testGetAppointmentById() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        Optional<Appointment> optionalAppointment = appointmentService.getAppointmentById(1L);

        assertEquals(appointment, optionalAppointment.get());
        verify(appointmentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAppointmentByIdObjectsDTO() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        Optional<AppointmentDTO> optionalAppointmentDTO = appointmentService.getAppointmentByIdObjectsDTO(1L);

        assertEquals(appointmentDTO.getAppCategory(), optionalAppointmentDTO.get().getAppCategory());
        assertEquals(appointmentDTO.getAppReason(), optionalAppointmentDTO.get().getAppReason());
        assertEquals(appointmentDTO.getAppDate(), optionalAppointmentDTO.get().getAppDate());
        verify(appointmentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllAppointmentsByPatientDTO() {
        when(appointmentRepository.findAll()).thenReturn(appointmentList);

        List<AppointmentDTO> appointmentDTOList = appointmentService.getAllAppointmentsByPatientDTO(1L);

        assertEquals(1, appointmentDTOList.size());
        verify(appointmentRepository, times(1)).findAll();
    }




    @Test
    void testEditAppointmentWithObjectsDTO() {
        // Create an existing appointment
        Appointment existingAppointment = new Appointment();
        existingAppointment.setAppID(1L);

        // Mock the behavior of the repositories and services
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(existingAppointment));
        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(new Employee()));
        when(patientService.getPatientById(1L)).thenReturn(Optional.of(new Patient()));
        when(appointmentRepository.save(existingAppointment)).thenReturn(existingAppointment); // Mock save method

        // Call the method under test
        Optional<Appointment> updatedAppointment = appointmentService.editAppointmentWithObjectsDTO(appointmentDTO);

        // Verify the result
        assertTrue(updatedAppointment.isPresent()); // Ensure the result is present
        assertEquals(existingAppointment, updatedAppointment.get()); // Check if the returned appointment matches the existing one
        verify(appointmentRepository, times(1)).findById(1L); // Verify that findById method was called once with the correct ID
        verify(appointmentRepository, times(1)).save(existingAppointment); // Verify that save method was called once with the existing appointment
    }






    @Test
    void testDeleteAppointment() {
        // Create an existing appointment
        Appointment existingAppointment = new Appointment();
        existingAppointment.setAppID(1L);

        // Mock the behavior of the repository
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(existingAppointment));

        // Call the method under test
        appointmentService.deleteAppointment(1L);

        // Verify the behavior
        verify(appointmentRepository, times(1)).findById(1L); // Verify that findById method was called once with the correct ID
        verify(appointmentRepository, times(1)).delete(existingAppointment); // Verify that delete method was called once with the existing appointment
    }







}