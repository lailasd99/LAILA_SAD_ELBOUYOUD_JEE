package ma.enset.examen_jee_lailasadelbouyoud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Comment;
import ma.enset.examen_jee_lailasadelbouyoud.enums.Gender;

import javax.persistence.*;
import java.util.List;


@Data
public class ParticipantDTO {
    private Long id;
    private String name;
    private String email;
    private String photo;
    private Gender gender;
}
