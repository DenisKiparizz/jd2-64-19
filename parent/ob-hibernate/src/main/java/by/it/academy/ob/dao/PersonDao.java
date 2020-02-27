package by.it.academy.ob.dao;

import OneToOne.employ.Person;

import java.io.Serializable;

public interface PersonDao {

    void create(Person person);

    void update(Person person);

    Person read(Serializable id);

    void delete(Person person);


}
