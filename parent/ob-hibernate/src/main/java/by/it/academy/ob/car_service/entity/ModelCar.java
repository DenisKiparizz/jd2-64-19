package by.it.academy.ob.car_service.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MODEL_CARS")
public class ModelCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car make;

    public ModelCar(String model, Car make) {
        this.model = model;
        this.make = make;
    }

}
