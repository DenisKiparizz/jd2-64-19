package by.it.academy.ob.service.Impl.car;

import by.it.academy.ob.dao.CarDAO;
import by.it.academy.ob.dao.MakeDAO;
import by.it.academy.ob.dao.impl.car.CarDaoImpl;
import by.it.academy.ob.dao.impl.car.MakeImplDAO;
import by.it.academy.ob.model.cars.Car;
import by.it.academy.ob.service.CarInterfaceSecond;
import by.it.academy.ob.service.MakeInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarImpl implements CarInterfaceSecond {
    public static final CarInterfaceSecond INSTANSE = new CarImpl();
    private static final CarDAO instanceDAO = CarDaoImpl.getInstance();

    public static CarInterfaceSecond getInstanse() {
        return INSTANSE;
    }

    @Override
    public void addCar(Car car) {
        try {
            Long result = instanceDAO.add(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Car> allCars() {
        List<Car> carList = new ArrayList<>();
        try {
            carList = instanceDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
}
