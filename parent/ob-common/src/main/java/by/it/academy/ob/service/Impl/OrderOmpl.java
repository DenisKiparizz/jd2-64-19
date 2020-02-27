package by.it.academy.ob.service.Impl;

import by.it.academy.ob.dao.OrderDAO;
import by.it.academy.ob.dao.impl.order.OrderDaoImpl;
import by.it.academy.ob.model.car_services.Order;
import by.it.academy.ob.service.OrderInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OrderOmpl implements OrderInterface {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);
    private static final OrderDAO inst = OrderDaoImpl.getInstance();
    private static final OrderOmpl INSTANCE = new OrderOmpl();

    public static OrderOmpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addOrder(Order order) {
        try {
            Long result = inst.add(order);
            order.setId(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order){
        try {
            int result = inst.update(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Order> findByID(Long id) {
        try {
            return inst.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteOrder(Long id) {
        try {
            int del = inst.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> list = null;
        try {
            list = inst.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
