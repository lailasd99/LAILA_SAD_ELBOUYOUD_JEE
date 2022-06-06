package ma.enset.examen_jee_lailasadelbouyoud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Guest;
import ma.enset.examen_jee_lailasadelbouyoud.entities.Session;
import ma.enset.examen_jee_lailasadelbouyoud.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
public class InscriptionDTO {
    private Long id;
    private Date date;
    private Status status;
    private double price;
    private GuestDTO guest;
    private SessionDTO session;
}
