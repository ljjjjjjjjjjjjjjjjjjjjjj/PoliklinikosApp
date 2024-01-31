
package lt.codeacademy.javau8.PoliklinikosApp.services;


import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalProduct;
import lt.codeacademy.javau8.PoliklinikosApp.entities.Patient;
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



    ////////////////
    // CRUD methods:
    ////////////////



    // Create (MedicalProduct)
    public MedicalProduct addMedicalProduct(MedicalProduct medicalProduct) {
        medicalProductRepository.save(medicalProduct);
        return medicalProduct;
    }


    // Read (All) (MedicalProduct)
    public List<MedicalProduct> getAllMedicalProducts() {
        return medicalProductRepository.findAll();}


    // Read (byID) (MedicalProduct)
    public Optional<MedicalProduct> getMedicalProductById(Long productID) {
        Optional<MedicalProduct> medicalServiceByID = medicalProductRepository.findById(productID);
        return medicalServiceByID;}



    // Update (MedicalProduct)
    public Optional<MedicalProduct> editMedicalProduct(MedicalProduct medicalProduct) {
        Optional<MedicalProduct> optionalMedicalProduct = getMedicalProductById(medicalProduct.getProductID());

        if (optionalMedicalProduct.isPresent()){
            MedicalProduct existingMedicalProduct = optionalMedicalProduct.get();
            existingMedicalProduct.setProductTitle(medicalProduct.getProductTitle());
            existingMedicalProduct.setProductCategory(medicalProduct.getProductCategory());
            existingMedicalProduct.setProductSubCategory(medicalProduct.getProductSubCategory());

            return Optional.of(medicalProductRepository.save(existingMedicalProduct));

        } else {
            return Optional.empty();
        }

    }


    // Delete
    public void deleteMedicalProduct(Long productID) {
        getMedicalProductById(productID).ifPresent(medicalProductToBeDeleted -> medicalProductRepository.delete(medicalProductToBeDeleted));
    }




}


//
