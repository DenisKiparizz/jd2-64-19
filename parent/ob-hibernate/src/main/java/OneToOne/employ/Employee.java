package OneToOne.employ;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true)
    @Access(AccessType.PROPERTY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDateTime dateTime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    private EmployDetails employDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTAMENT_ID")
    private Departament departament;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Employee_Meeting", joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MEETING_ID")})
    //ManyToMany
    private List<Meeting> meeting = new ArrayList<>();
    public Employee(Long id, String firstName, String lastName) {
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
