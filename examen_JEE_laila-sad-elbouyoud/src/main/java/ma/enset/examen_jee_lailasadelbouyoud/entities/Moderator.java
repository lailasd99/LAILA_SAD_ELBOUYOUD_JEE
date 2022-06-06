package ma.enset.examen_jee_lailasadelbouyoud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Moderator extends Participant{
    private String speciality;
    @OneToMany(mappedBy = "moderator")
    private List<Session> sessions;
}
