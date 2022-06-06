package ma.enset.examen_jee_lailasadelbouyoud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date startingTime;
    @Temporal(TemporalType.TIME)
    private Date finishTime;
    private String description;
    @ManyToOne
    private Session session;
    @ManyToOne
    private Speaker speaker;
    @OneToMany(mappedBy = "conference")
    private List<Comment> comments;
}
