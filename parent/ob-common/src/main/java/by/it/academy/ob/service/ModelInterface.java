package by.it.academy.ob.service;

import by.it.academy.ob.model.cars.Model;

import java.util.List;
import java.util.Optional;

public interface ModelInterface {
    List<Model> allCars();
    Optional<Model> getByID(Long id);
    List<Model> getModelsByID(Long id);
}
