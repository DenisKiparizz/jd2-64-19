package by.it.academy.ob.service.Impl.car;

import by.it.academy.ob.dao.MakeDAO;
import by.it.academy.ob.dao.impl.car.MakeImplDAO;
import by.it.academy.ob.model.cars.Make;
import by.it.academy.ob.service.MakeInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MakeImpl implements MakeInterface {
    public static final MakeInterface INSTANSE = new MakeImpl();
    private static final MakeDAO instanceDAO = MakeImplDAO.getInstance();

    public static MakeInterface getInstanse() {
        return INSTANSE;
    }

    @Override
    public List<Make> getAll() {
        List<Make> list = new ArrayList<>();
        try {
            list = instanceDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Make> listOfCars() {
        return null;
    }

    @Override
    public void addCar(Make car) {

    }

    @Override
    public Make findById(Long id) {
        return null;
    }

    @Override
    public void deliteCar(Long id) {

    }
}
