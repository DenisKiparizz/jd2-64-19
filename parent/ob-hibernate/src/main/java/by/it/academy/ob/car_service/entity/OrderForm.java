package by.it.academy.ob.car_service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_FORM_HIBERNATE")
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_FORM_ID")
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_CARS")
    private ModelCar modelCar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SERVICE_CAR", joinColumns = {@JoinColumn(name = "ORDER_FORM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SERVICE_ID")})
    private List<Service> services = new ArrayList<>();

    public OrderForm(Long id, String name, ModelCar modelCar, User user) {
        this.id = id;
        this.name = name;
        this.modelCar = modelCar;
        this.user = user;
    }

}
