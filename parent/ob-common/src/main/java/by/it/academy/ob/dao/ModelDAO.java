package by.it.academy.ob.dao;

import by.it.academy.ob.model.cars.Model;

import java.sql.SQLException;
import java.util.List;

public interface ModelDAO extends DAO<Model> {
    List<Model> getModelsByID(Long id)throws SQLException;

}
