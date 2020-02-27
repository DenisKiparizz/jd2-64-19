package by.it.academy.ob.service;

import by.it.academy.ob.model.car_services.Order;

import java.util.List;
import java.util.Optional;

public interface OrderInterface {
    void addOrder(Order order);

    void deleteOrder(Long id);

    void update(Order order);

    List<Order> getAll();
    Optional<Order> findByID(Long id);
}
