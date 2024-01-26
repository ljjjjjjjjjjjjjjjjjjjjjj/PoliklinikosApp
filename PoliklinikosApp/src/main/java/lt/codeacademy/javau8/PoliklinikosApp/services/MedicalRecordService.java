
package lt.codeacademy.javau8.PoliklinikosApp.services;


import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalRecord;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {


    public MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }



    ////////////////
    // CRUD methods:
    ////////////////



    // Create (MedicalRecord)
    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
        return medicalRecord;
    }


    // Read (All) (MedicalRecord)
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();}


    // Read (byID) (MedicalRecord)
    public Optional<MedicalRecord> getMedicalRecordById(Long recordID) {
        Optional<MedicalRecord> medicalServiceByID = medicalRecordRepository.findById(recordID);
        return medicalServiceByID;}



    // Update (MedicalRecord)
    public Optional<MedicalRecord> editMedicalRecord(MedicalRecord medicalRecord) {
        Optional<MedicalRecord> optionalMedicalRecord = getMedicalRecordById(medicalRecord.getRecordID());

        if (optionalMedicalRecord.isPresent()){
            MedicalRecord existingMedicalRecord = optionalMedicalRecord.get();
            existingMedicalRecord.setRecordCategory(medicalRecord.getRecordCategory());
            existingMedicalRecord.setRecordContent(medicalRecord.getRecordContent());
            existingMedicalRecord.setRecordDate(medicalRecord.getRecordDate());

            return Optional.of(medicalRecordRepository.save(existingMedicalRecord));

        } else {
            return Optional.empty();
        }

    }


    // Delete
    public void deleteMedicalRecord(Long recordID) {
        getMedicalRecordById(recordID).ifPresent(medicalRecordToBeDeleted -> medicalRecordRepository.delete(medicalRecordToBeDeleted));
    }




}


//
