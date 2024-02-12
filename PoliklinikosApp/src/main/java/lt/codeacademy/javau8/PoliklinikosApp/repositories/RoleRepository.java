
package lt.codeacademy.javau8.PoliklinikosApp.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau8.PoliklinikosApp.models.ERole;
import lt.codeacademy.javau8.PoliklinikosApp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
