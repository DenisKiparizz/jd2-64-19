package by.it.academy.ob.service.Impl.car;

import by.it.academy.ob.dao.ModelDAO;
import by.it.academy.ob.dao.impl.car.ModelDaoImpl;
import by.it.academy.ob.model.cars.Model;
import by.it.academy.ob.service.ModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModelImpl implements ModelInterface {
    private static final Logger logger = LoggerFactory.getLogger(ModelImpl.class);
    private static final ModelDAO inst = ModelDaoImpl.getInstance();
    private static final ModelImpl INSTANCE = new ModelImpl();

    public static ModelImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Model> allCars() {
        List<Model> models = null;
        try {
            models = inst.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public Optional<Model> getByID(Long id) {
        Optional<Model> model = Optional.empty();
        try {
            model = inst.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public List<Model> getModelsByID(Long id) {
        List<Model> models = new ArrayList<>();
        try {
            models = inst.getModelsByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }
}
