package ma.enset.examen_jee_lailasadelbouyoud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Conference;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Participant;

import javax.persistence.*;
import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private Date date;
    private String content;
    private Integer numberOfLikes;
    private ConferenceDTO conference;
    private ParticipantDTO participant;
}
