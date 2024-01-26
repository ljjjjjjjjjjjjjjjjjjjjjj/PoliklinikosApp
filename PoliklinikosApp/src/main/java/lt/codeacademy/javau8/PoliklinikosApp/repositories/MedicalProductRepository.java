package lt.codeacademy.javau8.PoliklinikosApp.repositories;

import lt.codeacademy.javau8.PoliklinikosApp.entities.MedicalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalProductRepository extends JpaRepository<MedicalProduct, Long> {
}


