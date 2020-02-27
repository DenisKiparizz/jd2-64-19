package by.it.academy.ob.service.Impl;

import by.it.academy.ob.dao.ServiceTypeDAO;
import by.it.academy.ob.dao.impl.order.ServiceTypeDaoImpl;
import by.it.academy.ob.model.car_services.Order;
import by.it.academy.ob.model.car_services.ServiceT;
import by.it.academy.ob.service.ServiceTypeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeImpl implements ServiceTypeInterface {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);
    private static final ServiceTypeDAO inst = ServiceTypeDaoImpl.getInstance();
    private static final ServiceTypeImpl INSTANCE = new ServiceTypeImpl();

    public static ServiceTypeImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public List<ServiceT> getAllServices() {
        List<ServiceT> service_type = new ArrayList<>();
        try {
            service_type = inst.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service_type;
    }
}
