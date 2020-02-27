package by.it.academy.ob.dao.impl.car;

import by.it.academy.ob.dao.EngineDao;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.cars.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EngineDaoImpl extends AbstractDAO implements EngineDao {
    protected EngineDaoImpl() {
        super(LoggerFactory.getLogger(EngineDaoImpl.class));
    }

    private static final EngineDaoImpl INSTANCE = new EngineDaoImpl();

    public static EngineDaoImpl getInstance() {
        return INSTANCE;
    }

    private static final String GET_ALL_ENGINE = "select * from engine;";

    @Override
    public Long add(Engine engine) throws SQLException {
        return null;
    }

    @Override
    public Optional<Engine> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(Engine engine) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Engine> getAll() throws SQLException {
        List<Engine> list = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ENGINE)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mappingEngine(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return list;
    }

    private Engine mappingEngine(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String typeOfengine = resultSet.getString("Type_of_engine");
        return new Engine(id, typeOfengine);
    }
}
