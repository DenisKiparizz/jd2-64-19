package by.it.academy.ob.service;

import by.it.academy.ob.model.cars.Car;

import java.util.List;

public interface CarInterfaceSecond {
    void addCar(Car car);

    List<Car> allCars();
}
