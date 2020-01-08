package by.it.academy.ob.dao.impl;

import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.dao.CarsDAO;
import by.it.academy.ob.model.Cars;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarsDao extends AbstractDAO implements CarsDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER_NAMME = "root";
    private static final String PASSWORD = "root";

    public CarsDao() {
        super(LoggerFactory.getLogger(CarsDao.class));
    }

    private static final CarsDao INSTANCE = new CarsDao();

    public static CarsDAO getInstance() {
        return INSTANCE;
    }

    public static final String INSERT_CAR = "INSERT INTO car(Make,Model,Type_of_body,Type_of_engine,Age,Value_of_Engine)VALUES(?,?,?,?,?,?);";
    public static final String SELECT_ALL = "SELECT * FROM car;";
    public static final String DELETE_BY_ID = "DELETE FROM car WHERE id=?;";

    @Override
    public int add(Cars cars) {
        ResultSet resultset = null;
        int resalt = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USER_NAMME, PASSWORD);
                 PreparedStatement statement = conn.prepareStatement(INSERT_CAR, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, cars.getMake());
                statement.setString(2, cars.getModel());
                statement.setString(3, cars.getBody());
                statement.setString(4, cars.getTypeOfEngine());
                statement.setLong(5, cars.getAge());
                statement.setDouble(6, cars.getValueOfEngine());
                statement.executeUpdate();
                resultset = statement.getGeneratedKeys();
                while (resultset.next()) {
                    resalt = resultset.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return resalt;
    }

    @Override
    public List<Cars> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Cars> cars = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(URL, USER_NAMME, PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(SELECT_ALL, Statement.RETURN_GENERATED_KEYS)) {
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Cars car = new Cars();
                    car.setId(resultSet.getLong(1));
                    car.setMake(resultSet.getString("MAKE"));
                    car.setModel(resultSet.getString("MODEL"));
                    car.setBody(resultSet.getString("TYPE_OF_BODY"));
                    car.setTypeOfEngine(resultSet.getString("TYPE_OF_ENGINE"));
                    car.setValueOfEngine(resultSet.getDouble(7));
                    car.setAge(resultSet.getLong(6));
                    cars.add(car);
                }
            }
        } catch (Exception e) {
            System.out.println("skno");
        }
        return cars;
    }

    @Override
    public int update(Cars cars) throws SQLException {
        return 0;
    }

    @Override
    public Long delete(Long id) throws SQLException {
        Long resalt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USER_NAMME, PASSWORD);
                 PreparedStatement statement = conn.prepareStatement(DELETE_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
                statement.setLong(1, id);
                //
                return Long.parseLong(String.valueOf(statement.executeUpdate()));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return resalt;
    }

    @Override
    public Optional<Cars> read(Long id) throws SQLException {
        return Optional.empty();
    }
}
