package OneToOne.employ;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MEETING_ID")
    @EqualsAndHashCode.Exclude
    private Long id;
    private String subject;
    private LocalDateTime dateTime;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER ,mappedBy = "meeting")
    private List<Employee> employees;

    public Meeting(String subject) {
        this.subject = subject;
        this.dateTime = LocalDateTime.now();
    }
}
