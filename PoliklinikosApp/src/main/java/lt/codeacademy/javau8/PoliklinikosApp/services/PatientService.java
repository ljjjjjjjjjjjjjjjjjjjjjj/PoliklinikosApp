
package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    public PatientRepository patientRepository;

    public PatientService( PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }




    // Dummy data:
    private final List<Patient> patientsList = new ArrayList<>();

    public List<Patient> getPatientsDummy() {
        List<Patient> patientDummyList = new ArrayList<>();
        Patient patient1 = new Patient(101L, "Vardenis1d", "Pavardenis1d");
        Patient patient2 = new Patient(102L,"Vardenis2d", "Pavardenis2d");

        patientDummyList.add(patient1);
        patientDummyList.add(patient2);

        return patientDummyList;
    }


    ////////////////
    // CRUD methods:
    ////////////////

    // Create
    public Patient addPatient(Patient patient) {
        patientsList.add(patient);
        return patient;
    }



    // Read (All)
    public List<Patient> getAllPatients() {
        return patientsList;}
    // Read (byID)
    public Optional<Patient> getPatientById(Long patientId) {
        Optional<Patient> patientByID = patientsList
                .stream()
                .filter(patient -> patient.getPatientID().equals(patientId)).findFirst();
        return patientByID;}


    // Update
    public Patient editPatient(long id, Patient updatedPatient) {
        Optional<Patient> patientOptional = getPatientById(id);
        if (patientOptional.isPresent()){
            Patient existingPatient = patientOptional.get();

            existingPatient.setPatientName(updatedPatient.getPatientName());
            existingPatient.setPatientSurname(updatedPatient.getPatientSurname());
            existingPatient.setPatientContactInfo(updatedPatient.getPatientContactInfo());
            existingPatient.setPatientCategory(updatedPatient.getPatientCategory());

            return existingPatient;

        } else {
            return null;
        }
    }

    public Patient editWithDummyData (Patient patient){
        patient.setPatientName("Edited");
        patient.setPatientSurname("Edited");
        patient.setPatientCategory("Edited");
        patient.setPatientContactInfo("Edited");
        return patient;
    }

    // Delete
    public void deletePatient(Long patientId) {
        Optional<Patient> patientOptional =  getPatientById(patientId);

        if (patientOptional.isPresent()) {
            Patient patientToBeDeleted = patientOptional.get();
            patientsList.remove(patientToBeDeleted);
        }
    }



}
