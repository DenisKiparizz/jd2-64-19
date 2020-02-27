package by.it.academy.ob.service.Impl.car;

import by.it.academy.ob.dao.BodyDAO;
import by.it.academy.ob.dao.CarDAO;
import by.it.academy.ob.dao.impl.car.BodyDaoImpl;
import by.it.academy.ob.dao.impl.car.CarDaoImpl;
import by.it.academy.ob.model.cars.Body;
import by.it.academy.ob.service.BodyInterface;
import by.it.academy.ob.service.CarInterfaceSecond;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BodyImpl implements BodyInterface {
    public static final BodyInterface INSTANSE = new BodyImpl();
    private static final BodyDAO instanceDAO = BodyDaoImpl.getInstance();

    public static BodyInterface getInstanse() {
        return INSTANSE;
    }
    @Override
    public List<Body> getAllBody() {
        List<Body> body = new ArrayList<>();
        try {
            body = instanceDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return body;
    }
}
