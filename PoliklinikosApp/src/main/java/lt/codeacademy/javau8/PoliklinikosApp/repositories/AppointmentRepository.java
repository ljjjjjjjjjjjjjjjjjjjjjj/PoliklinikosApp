
package lt.codeacademy.javau8.PoliklinikosApp.repositories;


import lt.codeacademy.javau8.PoliklinikosApp.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
