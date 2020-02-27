package by.it.academy.ob.dao.impl.uses;

import by.it.academy.ob.dao.UserDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.User;
import org.slf4j.LoggerFactory;

import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDAO implements UserDAO {
    public static final UserDAO INSTANCE = new UserDaoImpl();

    protected UserDaoImpl() {
        super(LoggerFactory.getLogger(UserDAO.class));
    }

    public static final String SELECT_BY_USERNAME = "select a.*,r.role_name from users a join roles r on role_id = r.id where a.username = ?;";
    public static final String INSERT_USER = "INSERT INTO users(name, surname, username, password, role_id)" +
            "VALUES(?,?,?,?,?);";

    public static final String GET_ROLE = "SELECT id FROM roles WHERE role_name = ?;";
    public static final String SELECT_ALL_FROM_USER = "SELECT a.*,r.role_name FROM users a JOIN roles r WHERE a.role_id=r.id;";


    public static UserDAO getiNSTANCE() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findByUsername(String username) throws SQLException {
        Optional<User> user = Optional.empty();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                user = Optional.of(mapUser(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return user;
    }

    @Override
    public Long add(User user) throws SQLException {
        ResultSet resultSet = null;
        Long resalt = null;
        Long role = null;
        try {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement statementROle = conn.prepareStatement(GET_ROLE)) {
                statementROle.setString(1, user.getRole());
                resultSet = statementROle.executeQuery();
                if (resultSet.next()) {
                    role = resultSet.getLong(1);
                }
                if (role == null) {
                    throw new RuntimeException("===Wrong roles number===");
                }
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getSecondName());
                statement.setString(3, user.getUserName());
                statement.setString(4, user.getPassword());
                statement.setLong(5, role);
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                while (resultSet.next()) {
                    resalt = resultSet.getLong(1);
                }
            } finally {
                closeQuietly(resultSet);
            }
        } catch (Exception e) {
            logger.error("======Add new User=======");
        }
        return resalt;
    }

    @Override
    public Optional<User> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<User> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FROM_USER)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(mapUser(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return list;
    }

    private User mapUser(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("name");
        String secondName = resultSet.getString("surname");
        String userName = resultSet.getString("username");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role_name");
        return new User(id, firstName, secondName, userName,password, role);
    }
}
