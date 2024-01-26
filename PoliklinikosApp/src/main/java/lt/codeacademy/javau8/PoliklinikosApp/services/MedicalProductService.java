
package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalProduct;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.MedicalProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalProductService {


    public MedicalProductRepository medicalProductRepository;

    public MedicalProductService( MedicalProductRepository medicalProductRepository) {
        this.medicalProductRepository = medicalProductRepository;
    }




    private final List<MedicalProduct> medicalProductsList = new ArrayList<>();

    public List<MedicalProduct> getMedicalServicesDummy() {
        List<MedicalProduct> medicalServicesDummyList = new ArrayList<>();
        MedicalProduct tyrimai1 = new MedicalProduct( "Kraujo tyrimai", "Tyrimai");
        MedicalProduct konsultacija1 = new MedicalProduct("Pirmine apziura", "Konsultacijos");

        medicalServicesDummyList.add(tyrimai1);
        medicalServicesDummyList.add(konsultacija1);

        return medicalServicesDummyList;
    }


    ////////////////
    // CRUD methods:
    ////////////////

    // Create
    public MedicalProduct addMedicalService(MedicalProduct medicalProduct) {
        medicalProductsList.add(medicalProduct);
        return medicalProduct;
    }



    // Read (All)
    public List<MedicalProduct> getAllMedicalServices() {
        return medicalProductsList;}
    // Read (byID)
    public Optional<MedicalProduct> getMedicalServiceById(Long serviceID) {
        Optional<MedicalProduct> medicalServiceByID = medicalProductsList.stream()
                .filter(medicalProduct -> medicalProduct.getProductID().equals(serviceID)).findFirst();
        return medicalServiceByID;}


    // Update
    public MedicalProduct editMedicalService(long id, MedicalProduct updatedMedicalProduct) {
        Optional<MedicalProduct> medicalServiceOptional = getMedicalServiceById(id);
        if (medicalServiceOptional.isPresent()){
            MedicalProduct existingMedicalProduct = medicalServiceOptional.get();

            existingMedicalProduct.setProductTitle(updatedMedicalProduct.getProductTitle());
            existingMedicalProduct.setProductCategory(updatedMedicalProduct.getProductCategory());

            return existingMedicalProduct;

        } else {
            return null;
        }
    }

    public MedicalProduct editWithDummyData (MedicalProduct medicalProduct){
        medicalProduct.setProductTitle("Edited");
        medicalProduct.setProductCategory("Edited");
        return medicalProduct;
    }

    // Delete
    public void deleteMedicalService(Long productID) {
        Optional<MedicalProduct> medicalServiceOptional =  getMedicalServiceById(productID);

        if (medicalServiceOptional.isPresent()) {
            MedicalProduct medicalProductToBeDeleted = medicalServiceOptional.get();
            medicalProductsList.remove(medicalProductToBeDeleted);
        }
    }

}
