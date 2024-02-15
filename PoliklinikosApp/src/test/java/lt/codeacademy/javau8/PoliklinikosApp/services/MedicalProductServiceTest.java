package lt.codeacademy.javau8.PoliklinikosApp.services;

import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalProduct;
import lt.codeacademy.javau8.PoliklinikosApp.repositories.MedicalProductRepository;
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

public class MedicalProductServiceTest {

    @Mock
    private MedicalProductRepository medicalProductRepository;

    @InjectMocks
    private MedicalProductService medicalProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllMedicalProducts() {
        MedicalProduct product1 = new MedicalProduct();
        product1.setProductID(1L);
        product1.setProductTitle("Product 1");

        MedicalProduct product2 = new MedicalProduct();
        product2.setProductID(2L);
        product2.setProductTitle("Product 2");

        List<MedicalProduct> products = Arrays.asList(product1, product2);

        when(medicalProductRepository.findAll()).thenReturn(products);

        List<MedicalProduct> result = medicalProductService.getAllMedicalProducts();

        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getProductTitle());
        assertEquals("Product 2", result.get(1).getProductTitle());
    }

    @Test
    void testGetMedicalProductById() {
        MedicalProduct product = new MedicalProduct();
        product.setProductID(1L);
        product.setProductTitle("Product 1");

        when(medicalProductRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<MedicalProduct> result = medicalProductService.getMedicalProductById(1L);

        assertEquals("Product 1", result.get().getProductTitle());
    }

    @Test
    void testAddMedicalProduct() {
        MedicalProduct product = new MedicalProduct();
        product.setProductID(1L);
        product.setProductTitle("Product 1");

        when(medicalProductRepository.save(any())).thenReturn(product);

        MedicalProduct savedProduct = medicalProductService.addMedicalProduct(product);

        assertEquals("Product 1", savedProduct.getProductTitle());
    }



    @Test
    void testEditMedicalProduct() {
        MedicalProduct existingProduct = new MedicalProduct();
        existingProduct.setProductID(1L);
        existingProduct.setProductTitle("Existing Product");
        existingProduct.setProductCategory("Category1");
        existingProduct.setProductSubCategory("Subcategory1");

        MedicalProduct updatedProduct = new MedicalProduct();
        updatedProduct.setProductID(1L);
        updatedProduct.setProductTitle("Updated Product");
        updatedProduct.setProductCategory("Category2");
        updatedProduct.setProductSubCategory("Subcategory2");

        when(medicalProductRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(medicalProductRepository.save(any())).thenReturn(updatedProduct);

        Optional<MedicalProduct> result = medicalProductService.editMedicalProduct(updatedProduct);

        assertTrue(result.isPresent());
        assertEquals("Updated Product", result.get().getProductTitle());
        assertEquals("Category2", result.get().getProductCategory());
        assertEquals("Subcategory2", result.get().getProductSubCategory());
    }

    @Test
    void testDeleteMedicalProduct() {
        MedicalProduct existingProduct = new MedicalProduct();
        existingProduct.setProductID(1L);

        when(medicalProductRepository.findById(1L)).thenReturn(Optional.of(existingProduct));

        medicalProductService.deleteMedicalProduct(1L);

        verify(medicalProductRepository, times(1)).delete(existingProduct);
    }




}