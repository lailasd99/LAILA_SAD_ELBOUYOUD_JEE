package ma.enset.examen_jee_lailasadelbouyoud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Guest extends Participant{
    private String affiliation;
    @OneToMany(mappedBy = "guest")
    private List<Inscription> inscription;
}
