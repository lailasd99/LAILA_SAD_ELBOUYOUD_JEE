package ma.enset.examen_jee_lailasadelbouyoud.repositories;

import ma.enset.examen_jee_lailasadelbouyoud.entities.Conference;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findBySession(Session session);
}
