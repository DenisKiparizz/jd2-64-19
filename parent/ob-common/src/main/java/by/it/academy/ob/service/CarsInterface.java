package by.it.academy.ob.service;

import by.it.academy.ob.model.Cars;

import java.util.List;

public interface CarsInterface {
    List<Cars> listOfCars();

    void addCar(Cars car);

    Cars findById(Long id);

    void deliteCar(Long id);


}
