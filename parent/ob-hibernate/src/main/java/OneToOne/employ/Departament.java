package OneToOne.employ;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTAMENT")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTAMENT_ID", unique = true)
    private Long departamentId;
    private String departamentName;
    @ToString.Exclude
    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employee = new HashSet<>();

    public Departament(String departamentName) {
        this.departamentName = departamentName;
    }
}
