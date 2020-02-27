package by.it.academy.ob.dao;

import by.it.academy.ob.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDAO extends DAO<User> {
    Optional<User> findByUsername(String username) throws SQLException;
}
