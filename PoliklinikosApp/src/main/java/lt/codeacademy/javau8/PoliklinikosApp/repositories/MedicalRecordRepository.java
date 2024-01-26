package lt.codeacademy.javau8.PoliklinikosApp.repositories;


import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}


