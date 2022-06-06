package ma.enset.examen_jee_lailasadelbouyoud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Conference;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Inscription;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Moderator;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Salle;

import javax.persistence.*;
import java.util.List;

@Data
public class SessionDTO {
    private Long id;
    private String name;
    private ModeratorDTO moderator;
    private SalleDTO salle;
}
