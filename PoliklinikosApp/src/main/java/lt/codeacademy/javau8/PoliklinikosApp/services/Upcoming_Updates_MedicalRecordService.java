
package lt.codeacademy.javau8.PoliklinikosApp.services;



public class Upcoming_Updates_MedicalRecordService {


/*



    public Upcoming_Updates_MedicalRecordRepository medicalRecordRepository;

    public Upcoming_Updates_MedicalRecordService(Upcoming_Updates_MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }



    ////////////////
    // CRUD methods:
    ////////////////



    // Create (MedicalRecord)
    public Upcoming_Updates_MedicalRecord addMedicalRecord(Upcoming_Updates_MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
        return medicalRecord;
    }


    // Read (All) (MedicalRecord)
    public List<Upcoming_Updates_MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();}


    // Read (byID) (MedicalRecord)
    public Optional<Upcoming_Updates_MedicalRecord> getMedicalRecordById(Long recordID) {
        Optional<Upcoming_Updates_MedicalRecord> medicalServiceByID = medicalRecordRepository.findById(recordID);
        return medicalServiceByID;}



    // Update (MedicalRecord)
    public Optional<Upcoming_Updates_MedicalRecord> editMedicalRecord(Upcoming_Updates_MedicalRecord medicalRecord) {
        Optional<Upcoming_Updates_MedicalRecord> optionalMedicalRecord = getMedicalRecordById(medicalRecord.getRecordID());

        if (optionalMedicalRecord.isPresent()){
            Upcoming_Updates_MedicalRecord existingMedicalRecord = optionalMedicalRecord.get();
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


*/


}


//
