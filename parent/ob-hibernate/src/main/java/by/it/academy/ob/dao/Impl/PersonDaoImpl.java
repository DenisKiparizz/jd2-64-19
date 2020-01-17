package by.it.academy.ob.dao.Impl;

import by.it.academy.ob.dao.PersonDao;
import by.it.academy.ob.entity.Person;
import by.it.academy.ob.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class PersonDaoImpl implements PersonDao {
    private static final PersonDaoImpl INSTANCE = new PersonDaoImpl();

    public static PersonDaoImpl getInstance() {
        return INSTANCE;

    }

    @Override
    public void create(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Person read(Serializable id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.get(Person.class, id);
    }
}
