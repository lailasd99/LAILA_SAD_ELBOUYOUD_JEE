package ma.enset.examen_jee_lailasadelbouyoud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "session")
    private List<Conference> conferences;
    @ManyToOne
    private Moderator moderator;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy = "session")
    private List<Inscription> inscriptions;
}
