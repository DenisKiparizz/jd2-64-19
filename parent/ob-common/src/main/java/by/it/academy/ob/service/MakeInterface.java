package by.it.academy.ob.service;

import by.it.academy.ob.model.cars.Make;

import java.util.List;

public interface MakeInterface {
    List<Make> listOfCars();

    void addCar(Make car);

    Make findById(Long id);

    void deliteCar(Long id);

    List<Make> getAll();
}
