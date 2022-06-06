package ma.enset.examen_jee_lailasadelbouyoud.repositories;

import ma.enset.examen_jee_lailasadelbouyoud.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
