package by.it.academy.ob.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<E> {
    int add(E e) throws SQLException;
    Optional<E> read(Long id) throws SQLException;
    int update(E e) throws SQLException;
    Long delete(Long id) throws SQLException;
    List<E> getAll() throws SQLException;
}
