package by.it.academy.ob.dao.impl.car;

import by.it.academy.ob.dao.CarDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.cars.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CarDaoImpl extends AbstractDAO implements CarDAO {
    protected CarDaoImpl() {
        super(LoggerFactory.getLogger(CarDaoImpl.class));
    }

    private static final CarDaoImpl INSTANCE = new CarDaoImpl();

    public static CarDaoImpl getInstance() {
        return INSTANCE;
    }

    private static final String GET_ALL_CAR = "SELECT * FROM car;";
    private static final String ADD_NEW_CAR = "insert into car(make_id, model_id, body_id, engine_id, engine_value, release_date)\n" +
            "VALUES (?, ?, ?, ?, ?, ?);";


    @Override
    public Long add(Car car) throws SQLException {
        Long result = null;
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CAR, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, car.getMake_id());
            preparedStatement.setLong(2, car.getModel_id());
            preparedStatement.setLong(3, car.getBody_id());
            preparedStatement.setLong(4, car.getBody_id());
            //next
            preparedStatement.setLong(5, car.getEngine_id());
            preparedStatement.setLong(6, car.getEngineValue());
            preparedStatement.setDate(7, (java.sql.Date) car.getReleaseDate());
            preparedStatement.executeLargeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public Optional<Car> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(Car car) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Car> getAll() throws SQLException {
        List<Car> carList = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CAR)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                carList.add(mappingCar(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return carList;
    }

    private Car mappingCar(ResultSet resultSet) throws SQLException {
        Long carID = resultSet.getLong("carID");
        Make make = new Make(resultSet.getLong("id"), resultSet.getString("Make"));
        Model model = new Model(resultSet.getLong("id"), resultSet.getString("Model"), new Make(resultSet.getLong("id"), resultSet.getString("Make")));
        Body body = new Body(resultSet.getLong("id"), resultSet.getString("Type_of_body"));
        Engine engine = new Engine(resultSet.getLong("id"), resultSet.getString("Type_of_body"));
        Long engine_value = resultSet.getLong("engine_value");
        Date date = new Date(resultSet.getNString("release_date"));
        return new Car(carID, make, model, body, engine, engine_value, date);
    }
}
