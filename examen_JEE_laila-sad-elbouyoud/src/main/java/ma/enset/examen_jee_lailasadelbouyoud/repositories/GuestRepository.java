package ma.enset.examen_jee_lailasadelbouyoud.repositories;

import ma.enset.examen_jee_lailasadelbouyoud.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
