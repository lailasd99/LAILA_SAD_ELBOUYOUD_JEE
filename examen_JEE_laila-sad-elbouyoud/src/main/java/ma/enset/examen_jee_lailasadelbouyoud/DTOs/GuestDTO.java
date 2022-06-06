package ma.enset.examen_jee_lailasadelbouyoud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Inscription;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Participant;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class GuestDTO extends Participant {
    private String affiliation;
}
