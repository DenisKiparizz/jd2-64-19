package OneToOne.employ;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
@Data
@Entity(name = "Person")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "GOODPERSONS")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "second_name", nullable = false)
    private String suranme;
    @Column(length = 3, nullable = true)
    private Integer age;
    @Formula(value = "CONCAT(first_name,' ' ,second_name)")
    private String fullName;
    @Embedded
    private Address address;
}
