package by.it.academy.ob.dao.impl.order;

import by.it.academy.ob.dao.ServiceTypeDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.car_services.ServiceT;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceTypeDaoImpl extends AbstractDAO implements ServiceTypeDAO {
    protected ServiceTypeDaoImpl() {
        super(LoggerFactory.getLogger(ServiceTypeDaoImpl.class));
    }

    private static ServiceTypeDaoImpl INSTANCE = new ServiceTypeDaoImpl();

    public static ServiceTypeDaoImpl getInstance() {
        return INSTANCE;
    }

    private static final String SELECT_ALL = "select * from service_type;";
    private static final String SELECT_BY_ID = "select * from service_type where id = ?;";

    @Override
    public Long add(ServiceT serviceT) throws SQLException {
        return null;
    }

    @Override
    public Optional<ServiceT> read(Long id) throws SQLException {
        Optional<ServiceT> service = Optional.empty();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                service = Optional.of(mapService(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return service;
    }

    @Override
    public int update(ServiceT serviceT) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<ServiceT> getAll() throws SQLException {
        List<ServiceT> particularServices = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                particularServices.add(mapService(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return particularServices;
    }

    private ServiceT mapService(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name_type");
        return new ServiceT(id, name);
    }
}
