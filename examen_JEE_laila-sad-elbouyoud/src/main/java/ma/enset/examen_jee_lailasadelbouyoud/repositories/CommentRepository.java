package ma.enset.examen_jee_lailasadelbouyoud.repositories;

import ma.enset.examen_jee_lailasadelbouyoud.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
