package by.it.academy.ob.dao.impl.car;

import by.it.academy.ob.dao.BodyDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.cars.Body;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BodyDaoImpl extends AbstractDAO implements BodyDAO {
    protected BodyDaoImpl() {
        super(LoggerFactory.getLogger(BodyDaoImpl.class));
    }

    private static final BodyDaoImpl INSTANCE = new BodyDaoImpl();

    public static BodyDaoImpl getInstance() {
        return INSTANCE;
    }

    private static final String GET_ALL_TYPE_OF_BODY = "select * from body;";

    @Override
    public Long add(Body body) throws SQLException {
        return null;
    }

    @Override
    public Optional<Body> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(Body body) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Body> getAll() throws SQLException {
        List<Body> list = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TYPE_OF_BODY)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mappingBody(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return list;
    }

    private Body mappingBody(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String typeOfBody = resultSet.getString("Type_of_body");
        Body body = new Body(id, typeOfBody);
        return body;

    }
}
