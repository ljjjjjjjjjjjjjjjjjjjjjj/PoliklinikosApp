
package lt.codeacademy.javau8.PoliklinikosApp.services;



import lt.codeacademy.javau8.PoliklinikosApp.entities.Employee;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    public PatientRepository patientRepository;

    public PatientService( PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



    ////////////////
    // CRUD methods:
    ////////////////

    // Create (Patient)
    public Patient addPatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }



    // Read (All) (Patient)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();}

    // Read (byID) (Patient)
    public Optional<Patient> getPatientById(Long patientId) {
        Optional<Patient> patientByID = patientRepository.findById(patientId);
        return patientByID;}



    // Read (ByName) (employee)
    public Optional<List<Patient>> getPatientsByName(String patientName) {
        List<Patient> listAllPatients = patientRepository.findAll();

        List<Patient> listFilteredPatients = listAllPatients
                .stream()
                .filter(e -> e.getPatientName().equals(patientName))
                .collect(Collectors.toList());

        if (listFilteredPatients.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(listFilteredPatients);
        }
    }


    // Update (Patient)
    public Optional<Patient> editPatient(Patient patient) {
        Optional<Patient> optionalPatient = getPatientById(patient.getPatientID());

        if (optionalPatient.isPresent()){
            Patient existingPatient = optionalPatient.get();
            existingPatient.setPatientName(patient.getPatientName());
            existingPatient.setPatientSurname(patient.getPatientSurname());
            existingPatient.setPatientAddress(patient.getPatientAddress());
            existingPatient.setPatientPhone(patient.getPatientPhone());
            existingPatient.setPatientEmail(patient.getPatientEmail());
            existingPatient.setPatientCategory(patient.getPatientCategory());

            return Optional.of(patientRepository.save(existingPatient));

        } else {
            return Optional.empty();
        }

    }


    // Delete (Patient)
    public void deletePatient(Long patientId) {
        getPatientById(patientId).ifPresent(patientToBeDeleted -> patientRepository.delete(patientToBeDeleted));

    }





}



//
