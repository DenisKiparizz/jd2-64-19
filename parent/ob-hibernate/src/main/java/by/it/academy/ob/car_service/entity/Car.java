package by.it.academy.ob.car_service.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARS_HIBERNATE")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private Long id;
    private String make;
    @ToString.Exclude
    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ModelCar> models = new ArrayList<>();
    public Car(String make) {
        this.make = make;
    }
}
