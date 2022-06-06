package ma.enset.examen_jee_lailasadelbouyoud.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Comment;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Session;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Speaker;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class ConferenceDTO {
    private Long id;
    private String title;
    private Date date;
    private Date startingTime;
    private Date finishTime;
    private String description;
    private SessionDTO session;
    private SpeakerDTO speaker;
}
