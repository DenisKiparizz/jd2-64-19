package by.it.academy.ob.dao;

import by.it.academy.ob.entity.Person;

import java.io.Serializable;
import java.util.List;

public interface PersonDao {

    void create(Person person);

    void update(Person person);

    Person read(Serializable id);

    void delete(Person person);


}
