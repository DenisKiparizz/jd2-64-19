package by.it.academy.ob.car_service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SERVICE_TYPE_HIBER")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICE_ID")
    @EqualsAndHashCode.Exclude
    private Long id;
    private String service_name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "services")
    private List<OrderForm> carModels;
    public Service(String service_name) {
        this.service_name = service_name;
    }

}
