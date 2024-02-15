

package lt.codeacademy.javau8.PoliklinikosApp.services;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testAddPatient() {
        Patient patient = new Patient();
        patient.setPatientID(1L);
        patient.setPatientName("John");

        when(patientRepository.save(patient)).thenReturn(patient);

        Patient result = patientService.addPatient(patient);

        assertEquals(patient, result);
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    void testGetAllPatients() {
        Patient patient1 = new Patient();
        patient1.setPatientID(1L);
        patient1.setPatientName("John");

        Patient patient2 = new Patient();
        patient2.setPatientID(2L);
        patient2.setPatientName("Jane");

        List<Patient> patients = Arrays.asList(patient1, patient2);

        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> result = patientService.getAllPatients();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getPatientName());
        assertEquals("Jane", result.get(1).getPatientName());
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient();
        patient.setPatientID(1L);
        patient.setPatientName("John");

        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.getPatientById(1L);

        assertTrue(result.isPresent());
        assertEquals(patient, result.get());
    }

    @Test
    void testGetPatientsByName() {
        Patient patient1 = new Patient();
        patient1.setPatientID(1L);
        patient1.setPatientName("John");

        Patient patient2 = new Patient();
        patient2.setPatientID(2L);
        patient2.setPatientName("John");

        List<Patient> patients = Arrays.asList(patient1, patient2);

        when(patientRepository.findAll()).thenReturn(patients);

        Optional<List<Patient>> result = patientService.getPatientsByName("John");

        assertTrue(result.isPresent());
        assertEquals(2, result.get().size());
        assertEquals("John", result.get().get(0).getPatientName());
        assertEquals("John", result.get().get(1).getPatientName());
    }




    @Test
    void testEditPatient() {
        Patient existingPatient = new Patient();
        existingPatient.setPatientID(1L);
        existingPatient.setPatientName("John");
        existingPatient.setPatientSurname("Doe");
        existingPatient.setPatientAddress("123 Main St");
        existingPatient.setPatientPhone("555-1234");
        existingPatient.setPatientEmail("john.doe@example.com");
        existingPatient.setPatientCategory("Category1");

        Patient updatedPatient = new Patient();
        updatedPatient.setPatientID(1L);
        updatedPatient.setPatientName("Jane");
        updatedPatient.setPatientSurname("Smith");
        updatedPatient.setPatientAddress("456 Elm St");
        updatedPatient.setPatientPhone("555-5678");
        updatedPatient.setPatientEmail("jane.smith@example.com");
        updatedPatient.setPatientCategory("Category2");

        when(patientRepository.findById(1L)).thenReturn(Optional.of(existingPatient));
        when(patientRepository.save(any())).thenReturn(updatedPatient);

        Optional<Patient> result = patientService.editPatient(updatedPatient);

        assertTrue(result.isPresent());
        assertEquals("Jane", result.get().getPatientName());
        assertEquals("Smith", result.get().getPatientSurname());
        assertEquals("456 Elm St", result.get().getPatientAddress());
        assertEquals("555-5678", result.get().getPatientPhone());
        assertEquals("jane.smith@example.com", result.get().getPatientEmail());
        assertEquals("Category2", result.get().getPatientCategory());
    }

    @Test
    void testDeletePatient() {
        Patient existingPatient = new Patient();
        existingPatient.setPatientID(1L);

        when(patientRepository.findById(1L)).thenReturn(Optional.of(existingPatient));

        patientService.deletePatient(1L);

        verify(patientRepository, times(1)).delete(existingPatient);
    }
}