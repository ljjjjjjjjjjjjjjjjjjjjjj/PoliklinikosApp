package lt.codeacademy.javau8.PoliklinikosApp.repositories;

import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientEmail(String patientEmail);
}
