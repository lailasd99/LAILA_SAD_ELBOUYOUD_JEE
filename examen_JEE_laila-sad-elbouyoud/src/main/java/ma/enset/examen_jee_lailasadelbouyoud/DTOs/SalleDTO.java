package ma.enset.examen_jee_lailasadelbouyoud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Session;

import javax.persistence.*;
import java.util.List;

@Data
public class SalleDTO {
    private Long id;
    private String name;
}
