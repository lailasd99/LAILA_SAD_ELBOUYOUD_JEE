package ma.enset.examen_jee_lailasadelbouyoud.repositories;

import ma.enset.examen_jee_lailasadelbouyoud.entities.Comment;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
