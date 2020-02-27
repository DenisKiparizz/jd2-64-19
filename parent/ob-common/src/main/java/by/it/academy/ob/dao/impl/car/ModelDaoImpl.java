package by.it.academy.ob.dao.impl.car;

import by.it.academy.ob.dao.ModelDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.cars.Make;
import by.it.academy.ob.model.cars.Model;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModelDaoImpl extends AbstractDAO implements ModelDAO {
    protected ModelDaoImpl() {
        super(LoggerFactory.getLogger(ModelDaoImpl.class));
    }

    private static final ModelDaoImpl INSTANCE = new ModelDaoImpl();

    public static ModelDaoImpl getInstance() {
        return INSTANCE;
    }

    public static final String ALL_CARS = "select m.*,o.Make from model m join make o on m.make_id = o.id order by Make;";
    public static final String GET_BY_ID = "select m.*,o.* from model m join make o on m.make_id = o.id where m.id = ?;";
    public static final String GET_LIST_BY_ID = "select m.*,o.* from make m join model o on m.id = o.make_id where m.id=?;";


    @Override
    public List<Model> getModelsByID(Long id) throws SQLException{
        List<Model> model = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_BY_ID)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                model.add(mappingModel(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return model;
    }

    @Override
    public Long add(Model model) throws SQLException {
        return null;
    }

    @Override
    public Optional<Model> read(Long id) throws SQLException {
        Optional<Model> model = Optional.empty();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                model = Optional.of(mappingModel(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return model;
    }


    @Override
    public int update(Model model) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Model> getAll() throws SQLException {
        List<Model> list = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_CARS)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mappingModel(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return list;
    }

    private Model mappingModel(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("Model");
        Make make = new Make(resultSet.getLong("id"), resultSet.getString("Make"));
        return new Model(id, name, make);

    }
}
