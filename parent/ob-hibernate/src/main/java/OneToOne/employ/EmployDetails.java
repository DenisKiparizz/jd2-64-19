package OneToOne.employ;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee_Details")
public class EmployDetails {
    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign", parameters = @Parameter(
            name = "property", value = "employee"
    ))
    @GeneratedValue(generator = "one-one")
    @Column(name = "EMPLOYEE_ID") @Access(AccessType.PROPERTY)
    private Long id;
    private String city;
    private String street;
    private String state;
    private String country;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @Access(AccessType.PROPERTY)
    private Employee employee;
}
