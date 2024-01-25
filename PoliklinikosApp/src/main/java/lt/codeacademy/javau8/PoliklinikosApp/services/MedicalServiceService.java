
package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalServiceService {

    private final List<MedicalService> medicalServicesList = new ArrayList<>();

    public List<MedicalService> getMedicalServicesDummy() {
        List<MedicalService> medicalServicesDummyList = new ArrayList<>();
        MedicalService tyrimai1 = new MedicalService( "Kraujo tyrimai", "Tyrimai");
        MedicalService konsultacija1 = new MedicalService("Pirmine apziura", "Konsultacijos");

        medicalServicesDummyList.add(tyrimai1);
        medicalServicesDummyList.add(konsultacija1);

        return medicalServicesDummyList;
    }


    ////////////////
    // CRUD methods:
    ////////////////

    // Create
    public MedicalService addMedicalService(MedicalService medicalService) {
        medicalServicesList.add(medicalService);
        return medicalService;
    }



    // Read (All)
    public List<MedicalService> getAllMedicalServices() {
        return medicalServicesList;}
    // Read (byID)
    public Optional<MedicalService> getMedicalServiceById(Long serviceID) {
        Optional<MedicalService> medicalServiceByID = medicalServicesList.stream().filter(medicalService -> medicalService.getServiceID().equals(serviceID)).findFirst();
        return medicalServiceByID;}


    // Update
    public MedicalService editMedicalService(long id, MedicalService updatedMedicalService) {
        Optional<MedicalService> medicalServiceOptional = getMedicalServiceById(id);
        if (medicalServiceOptional.isPresent()){
            MedicalService existingMedicalService = medicalServiceOptional.get();

            existingMedicalService.setServiceTitle(updatedMedicalService.getServiceTitle());
            existingMedicalService.setServiceCategory(updatedMedicalService.getServiceCategory());

            return existingMedicalService;

        } else {
            return null;
        }
    }

    public MedicalService editWithDummyData (MedicalService medicalService){
        medicalService.setServiceTitle("Edited");
        medicalService.setServiceCategory("Edited");
        return medicalService;
    }

    // Delete
    public void deleteMedicalService(Long serviceID) {
        Optional<MedicalService> medicalServiceOptional =  getMedicalServiceById(serviceID);

        if (medicalServiceOptional.isPresent()) {
            MedicalService medicalServiceToBeDeleted = medicalServiceOptional.get();
            medicalServicesList.remove(medicalServiceToBeDeleted);
        }
    }

}
