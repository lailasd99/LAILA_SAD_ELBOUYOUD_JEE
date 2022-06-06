package ma.enset.examen_jee_lailasadelbouyoud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.enums.Gender;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor
public class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String photo;
    private Gender gender;
    @OneToMany(mappedBy = "participant")
    private List<Comment> comments;
}
