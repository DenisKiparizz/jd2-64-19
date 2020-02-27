package by.it.academy.ob.dao.impl.order;

import by.it.academy.ob.dao.OrderDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.car_services.Order;
import by.it.academy.ob.model.car_services.ServiceT;
import by.it.academy.ob.model.cars.Make;
import by.it.academy.ob.model.cars.Model;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDAO implements OrderDAO {
    protected OrderDaoImpl() {
        super(LoggerFactory.getLogger(OrderDaoImpl.class));
    }

    private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();

    public static OrderDaoImpl getInstance() {
        return INSTANCE;
    }

    public static final String ADD_NEW_ORDER = "insert into orders(title,service_type_id, description) values (?,?,?);";
    public static final String DELETE = "delete from orders where id = ?;";
    public static final String GET_ORDERS = "select o.*,s.* from orders o join service_type s on o.service_type_id = s.id;";
    public static final String UPDATE = "update orders set title = ?,service_type_id = ?,description = ? where id  = ?;";
    public static final String GET_BY_ID = "select * from orders where id=?;";

    @Override
    public Long add(Order order) throws SQLException {
        Long result = null;
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_ORDER,PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getTitle());
            preparedStatement.setLong(2, order.getServiceType_id());
            preparedStatement.setString(3, order.getDescription());
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
    public Optional<Order> read(Long id) throws SQLException {
        Optional<Order> order = Optional.empty();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = Optional.of(mappingOrder(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return order;
    }

    @Override
    public int update(Order order) throws SQLException {
        int result = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, order.getId());
            preparedStatement.setString(2, order.getTitle());
            preparedStatement.setLong(3, order.getServiceType_id());
            preparedStatement.setString(4, order.getDescription());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int delete(Long id) throws SQLException {
        int result = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
            return result;
        }
    }

    @Override
    public List<Order> getAll() throws SQLException {
        List<Order> list = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mappingOrder(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return list;
    }

    private Order mappingOrder(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        ServiceT serviceT = new ServiceT(resultSet.getLong("id"), resultSet.getString("name_type"));
        String description = resultSet.getString("description");
        return new Order(id, title, serviceT, description);
    }

}
